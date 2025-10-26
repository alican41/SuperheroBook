package com.alica.superherobook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alica.superherobook.ui.theme.SuperheroBookTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {

    private val superheroList = ArrayList<Superhero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            SuperheroBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){

                        NavHost(navController = navController,
                            startDestination = "list_screen"){

                            composable("list_screen"){
                                getData()
                                SuperheroList(superheros = superheroList,
                                    navController = navController)
                            }
                            composable ("details_screen/{superhero}",
                                arguments = listOf(
                                    navArgument("superhero"){
                                        type = NavType.StringType
                                    }
                                )){
                                superheroList.clear()
                                val superheroString = remember {
                                    it.arguments?.getString("superhero")
                                }
                                val selectedSuperhero = Gson().fromJson(superheroString,Superhero::class.java)
                                DetailScreen(superhero = selectedSuperhero)
                            }

                        }




                    }
                }
            }
        }
    }

    fun getData(){
        val superman = Superhero("Superman","DC",R.drawable.superman)
        val batman = Superhero("Batman","DC",R.drawable.batman)
        val hulk = Superhero("Hulk","Marvel",R.drawable.hulk)
        val spiderman = Superhero("Spider-Man","Marvel",R.drawable.spiderman)
        val ironman = Superhero("Iron Man","Marvel",R.drawable.ironman)
        val captainAmerica = Superhero("Captain America","Marvel",R.drawable.captainamerica)
        val thor = Superhero("Thor","Marvel",R.drawable.thor)
        val wonderWoman = Superhero("Wonder Woman","DC",R.drawable.wonderwoman)
        val theFlash = Superhero("The Flash","DC",R.drawable.theflash)
        val aquaman = Superhero("Aquaman","DC",R.drawable.aquaman)
        val deadpool = Superhero("Deadpool","Marvel",R.drawable.deadpool)
        val wolverine = Superhero("Wolverine","Marvel",R.drawable.wolverine)
        val greenLantern = Superhero("Green Lantern","DC",R.drawable.greenlantern)
        val cyborg = Superhero("Cyborg","DC",R.drawable.cyborg)

        superheroList.add(superman)
        superheroList.add(batman)
        superheroList.add(hulk)
        superheroList.add(spiderman)
        superheroList.add(ironman)
        superheroList.add(captainAmerica)
        superheroList.add(thor)
        superheroList.add(wonderWoman)
        superheroList.add(theFlash)
        superheroList.add(aquaman)
        superheroList.add(deadpool)
        superheroList.add(wolverine)
        superheroList.add(greenLantern)
        superheroList.add(cyborg)






    }


}


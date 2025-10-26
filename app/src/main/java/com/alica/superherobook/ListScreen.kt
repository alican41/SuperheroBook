package com.alica.superherobook

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson

@Composable
fun SuperheroList(superheros : List<Superhero>, navController: NavController){
    LazyColumn(contentPadding = PaddingValues(10.dp),
        modifier = Modifier.fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        items(superheros){
            SuperheroRow(superhero = it, navController = navController)
        }
    }
}

@Composable
fun SuperheroRow(superhero: Superhero,navController: NavController){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 6.dp, horizontal = 4.dp)
        .clickable{
            navController.navigate(
                "details_screen/${Gson().toJson(superhero)}"
            )
        },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        // Ana düzenimiz yatay (Row) olacak
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp), // Kartın iç boşluğu (bu sizin "pay" dediğiniz kısım)
            verticalAlignment = Alignment.CenterVertically // İçeriklerin dikeyde ortalanmasını sağlar
        ) {
            // SOL TARAF: Resim
            Image(
                painter = painterResource(id = superhero.image),
                contentDescription = superhero.name,
                // Resmi bir kare içine sığdırıp, taşan kısımları kırpıyoruz
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp) // Resim boyutunu büyüttük
                    .clip(RoundedCornerShape(8.dp)) // Resmin köşelerini yuvarlıyoruz
            )

            // Resim ile metinler arasına boşluk
            Spacer(modifier = Modifier.width(16.dp))

            // SAĞ TARAF: Metinler (Alt alta)
            Column(
                modifier = Modifier.weight(1f) // Kalan tüm yatay alanı kapla
            ) {
                Text(
                    superhero.name,
                    style = MaterialTheme.typography.headlineMedium, // İsmi daha belirgin yaptık
                    fontWeight = FontWeight.Bold
                )

                // İsim ve evren arasına hafif bir boşluk
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    superhero.universe,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Normal,
                    // Evren bilgisini biraz daha soluk bir renkle yazabiliriz
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
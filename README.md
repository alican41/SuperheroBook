# 🦸 Superhero Book (Süper Kahraman Kitabı)

Bu proje, **Jetpack Compose** kullanılarak geliştirilmiş basit bir Android uygulamasıdır. Uygulama, süper kahramanların bir listesini gösterir ve listeden seçilen kahramanın detaylarını ayrı bir ekranda sunar.

Bu proje, Jetpack Compose kullanarak temel liste-detay (list-detail) yapısının, ekranlar arası veri aktarımının ve navigasyonun nasıl yapıldığını gösteren bir örnek niteliğindedir.

## 📱 Ekran Görüntüleri

Uygulamanın nasıl göründüğüne dair temel ekranlar aşağıdadır.

| Ana Ekran (Liste) | Detay Ekranı |
| :---: | :---: |
| ![Ana Ekran](https://github.com/user-attachments/assets/1b313e46-10d1-40af-91b6-f768044f564c) | ![Detay Ekranı](https://github.com/user-attachments/assets/272ab7b1-5180-42a4-892a-006f678caeb6)

## ✨ Özellikler

* Süper kahramanları modern bir `Card` görünümünde `LazyColumn` kullanarak listeleme.
* Listedeki herhangi bir kahramana tıklandığında **Compose Navigation** kullanarak detay ekranına geçiş yapma.
* **Gson** kütüphanesi kullanarak `Superhero` nesnesini bir JSON string'e dönüştürme ve navigasyon argümanı olarak detay ekranına güvenle taşıma.
* Detay ekranında kahramana ait büyük görseli, ismi ve evreni (Marvel/DC) gösterme.

## 🛠️ Kullanılan Teknolojiler ve Kütüphaneler

Bu projede aşağıdaki modern Android geliştirme araçları kullanılmıştır:

* **[Kotlin](https://kotlinlang.org/):** Ana programlama dili.
* **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Kullanıcı arayüzünü (UI) oluşturmak için kullanılan modern, deklaratif UI kiti.
    * **Material 3:** Modern tasarım bileşenleri (`Scaffold`, `Card`, `Text` vb.).
    * **`LazyColumn`:** Performanslı kaydırılabilir listeler oluşturmak için.
    * **`Image`:** Proje içindeki (`drawable`) görselleri göstermek için.
* **[Compose Navigation](https://developer.android.com/jetpack/compose/navigation):** Uygulama içi ekran geçişlerini (navigasyonu) yönetmek için.
* **[Gson](https://github.com/google/gson):** Özel `Superhero` nesnesini, navigasyon sırasında ekranlar arası kolayca aktarabilmek için JSON formatına çevirmek (serialize/deserialize) amacıyla kullanılmıştır.

## 🚀 Kurulum ve Çalıştırma

Projeyi yerel makinenizde çalıştırmak için:

1.  Bu repoyu klonlayın:
    ```bash
    git clone [PROJE-LINKINIZ-BURAYA-GELECEK]
    ```
2.  Projeyi **Android Studio**'da açın.
3.  Uygulamayı bir Android emülatörde veya fiziksel bir cihazda çalıştırın (`Run 'app'`).

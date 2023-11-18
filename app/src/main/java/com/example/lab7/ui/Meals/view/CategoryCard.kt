package com.example.lab7.ui.Meals.view

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter

@Composable
fun CategoryCard(
    categoryId: String,
    categoryName: String,
    categoryDescription: String,
    categoryImageUrl: String,  // Ahora es una URL
    navController: NavController
) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(80.dp)// Ancho fijo
            .padding(8.dp)
            .background(color = Color.LightGray)
            .clickable {
                val encodedName = Uri.encode(categoryName)
                navController.navigate("recipesByCategory/$encodedName")
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(data = categoryImageUrl),  // Usando Coil para cargar la imagen
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)  // Puedes ajustar esto según tus necesidades
            )
            Spacer(modifier = Modifier.height(8.dp))  // Espacio entre la imagen y el texto
            Text(
                text = categoryName,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }
    }
}
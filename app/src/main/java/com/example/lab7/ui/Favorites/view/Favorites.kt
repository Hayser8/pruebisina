package com.example.lab7.ui.Favorites.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lab7.R
import com.example.lab7.ui.Login.model.Favorite

@Composable
fun FavoritesContent() {
    // Columna principal que ocupa todo el espacio disponible
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp), // Espaciado vertical entre los hijos
        horizontalAlignment = Alignment.CenterHorizontally // Alineación horizontal al centro
    ) {
        // Barra de título en la parte superior
        Row(
            modifier = Modifier.fillMaxWidth().background(Color.Black),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Eventos Favoritos",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(30.dp)
            )
        }

        // Lista de favoritos
        Column(modifier = Modifier.padding(16.dp)) {
            // Datos de muestra para la lista de favoritos
            val favorites = listOf(
                Favorite("Concierto de Bad Bunny", "Cardales", R.drawable.bbbello),
                Favorite("Concierto de Billie Eilish", "Cardales", R.drawable.billiemiamor),
                Favorite("Concierto de C. Tangana", "Parque de la industria", R.drawable.ctangana),
                Favorite("Concierto de Labrynth", "Majadas", R.drawable.labrinth)
            )

            // Itera sobre cada favorito y crea una tarjeta para él
            favorites.forEach { favorite ->
                FavoriteCard(favorite)
            }
        }
    }
}

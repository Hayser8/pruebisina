package com.example.lab7.ui.Favorites.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab7.ui.Login.model.Favorite

// Tarjeta de favorito individual
@Composable
fun FavoriteCard(favorite: Favorite) {
    // Tarjeta con sombra y forma rectangular
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(135.dp) // Altura fija
            .padding(8.dp), // Espacio externo
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RectangleShape // Esquinas cuadradas
    ) {
        // Contenido de la tarjeta
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically // Alineación vertical al centro
        ) {
            // Muestra la imagen del favorito
            Image(
                painter = painterResource(id = favorite.imageResourceId),
                contentDescription = "Event Image",
                modifier = Modifier.size(100.dp) // Tamaño fijo de la imagen
            )
            Spacer(modifier = Modifier.width(16.dp)) // Espacio entre la imagen y el texto
            Column {
                // Título del favorito
                Text(
                    text = favorite.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp)) // Espacio entre el título y la ubicación
                // Ubicación del favorito
                Text(
                    text = favorite.location,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
            Spacer(modifier = Modifier.weight(1f)) // Espacio flexible al final de la fila
        }
    }
}

package com.example.lab7.ui.Event.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lab7.ui.Event.model.Event

@Composable
fun InfoConciertosScreen(events: List<Event>, navController: NavController) {
    // Contenedor principal que se ajusta al tamaño máximo disponible
    Box(modifier = Modifier.fillMaxSize()) {
        // Columna con capacidad de desplazamiento vertical
        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            // Barra superior de la aplicación
            Row(
                modifier = Modifier.fillMaxWidth().background(Color.Black),
                horizontalArrangement = Arrangement.SpaceBetween // Organizar los elementos con espacio entre ellos
            ) {
                // Título de la aplicación
                Text(
                    "EventosMax+",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )
                // Botón con tres puntos verticales, para futuras opciones
                IconButton(onClick = { /* acción para los tres puntitos */ }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "Más opciones", tint = Color.White)
                }
            }
            // Espacio entre la barra superior y los eventos
            Spacer(modifier = Modifier.height(16.dp))
            // Lista de eventos en una cuadrícula de 2xN
            Column(modifier = Modifier.padding(16.dp)) {
                for (index in events.indices step 2) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Mostrar el evento de la izquierda
                        EventItem(event = events[index], navController = navController)
                        // Si hay un evento de la derecha, mostrarlo. De lo contrario, mostrar espacio vacío.
                        if (index + 1 < events.size) {
                            EventItem(event = events[index+1], navController = navController)
                        } else {
                            Box(modifier = Modifier.weight(1f))
                        }
                    }
                    // Espacio entre las filas de eventos
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
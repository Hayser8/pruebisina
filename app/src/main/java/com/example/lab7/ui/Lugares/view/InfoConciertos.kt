package com.example.lab7.ui.Lugares.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lab7.ui.Lugares.model.Concierto

@Composable
fun InfoConciertos(events: List<Concierto>) {
    // Contenedor principal que ocupa todo el espacio disponible
    Box(modifier = Modifier.fillMaxSize()) {
        // Columna perezosa que permite desplazarse y se usa para mostrar la lista de conciertos
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            // Itera sobre cada concierto y muestra su información
            items(events) { concierto ->
                Event(concierto = concierto)
                Spacer(modifier = Modifier.height(8.dp))  // Espaciado entre elementos
                Divider(color = Color.Gray, thickness = 0.5.dp)  // Línea divisoria entre elementos
            }
        }
    }
}
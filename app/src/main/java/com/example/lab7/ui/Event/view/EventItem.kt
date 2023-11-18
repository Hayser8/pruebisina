package com.example.lab7.ui.Event.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.lab7.ui.Event.model.Event

@Composable
fun EventItem(event: Event, navController: NavController) {
    // Contenedor de evento que puede ser tocado
    Column(
        modifier = Modifier
            .width(160.dp)  // Ancho fijo
            .clickable {navController.navigate("detalle/${event.title}/${event.fecha}/${event.hora}/${event.description}/${event.imageRes}")}
            .padding(8.dp)
            .background(color = Color.LightGray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente
    ) {
        // Muestra la imagen del evento
        Image(
            painter = painterResource(id = event.imageRes),
            contentDescription = null,
            modifier = Modifier.size(64.dp).align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Título del evento
        Text(
            event.title,
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        // Descripción del evento
        Text(
            event.description,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

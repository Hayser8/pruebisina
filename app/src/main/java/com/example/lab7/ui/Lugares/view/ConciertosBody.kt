package com.example.lab7.ui.Lugares.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab7.ui.Lugares.model.Concierto

@Composable
fun Event(concierto: Concierto) {
    // Contenedor en fila para mostrar la información de un concierto
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,  // Distribución de espacio entre hijos
        verticalAlignment = Alignment.CenterVertically     // Alineación vertical al centro
    ) {
        // Imagen del concierto a la izquierda
        Image(
            painter = painterResource(id = concierto.imageRes),
            contentDescription = null,  // No es necesario describir el contenido
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)       // Dar forma circular a la imagen
                .padding(8.dp),
            contentScale = ContentScale.Crop  // Escalar el contenido para recortar
        )

        // Columna para mostrar el título y la descripción del concierto
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = concierto.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,              // Limitar a 2 líneas
                overflow = TextOverflow.Ellipsis  // Puntos suspensivos si el texto es largo
            )
            Text(
                text = concierto.description,
                fontSize = 16.sp,
                maxLines = 3,              // Limitar a 3 líneas
                overflow = TextOverflow.Ellipsis  // Puntos suspensivos si el texto es largo
            )
        }

        // Imagen del concierto a la derecha
        Image(
            painter = painterResource(id = concierto.imageRightRes),
            contentDescription = null,  // No es necesario describir el contenido
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)       // Dar forma circular a la imagen
                .padding(8.dp),
            contentScale = ContentScale.Crop  // Escalar el contenido para recortar
        )
    }
}

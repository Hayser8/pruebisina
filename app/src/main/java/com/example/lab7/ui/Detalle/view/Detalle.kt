package com.example.lab5


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun DetalleComposable(
    titulo: String,
    fecha: String,
    hora: String,
    descripcion: String,
    imageRes: Int,
    navController: NavController
) {
    // Columna principal que permite desplazamiento vertical
    Column(
        modifier = Modifier
            .fillMaxSize()  // Ajusta el tamaño al máximo disponible
            .verticalScroll(rememberScrollState()) // Habilita el desplazamiento vertical
    ) {
        // Contenedor para la imagen y el botón de regreso
        Box(
            modifier = Modifier.fillMaxWidth().height(200.dp),
            contentAlignment = Alignment.TopStart // Alinea el contenido al inicio superior
        ) {
            // Muestra la imagen
            Image(
                painter = painterResource(id = imageRes), // Recurso de la imagen
                contentDescription = null,  // Descripción para accesibilidad
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // Recorta la imagen para que se ajuste al tamaño
            )
            // Botón para regresar
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
            }
        }

        // Espacio entre la imagen y el texto
        Spacer(modifier = Modifier.height(16.dp))

        // Muestra el título
        Text(
            text = titulo,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(start = 16.dp)
        )

        // Espacio entre el título y la fecha/hora
        Spacer(modifier = Modifier.height(8.dp))

        // Muestra la fecha y la hora en una fila
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, // Espacia los elementos igualmente
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = fecha)  // Muestra la fecha
            Text(text = hora)   // Muestra la hora
        }

        // Espacio entre la fecha/hora y el título de la descripción
        Spacer(modifier = Modifier.height(8.dp))

        // Título "Descripción"
        Text(
            text = "Descripción",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 16.dp)
        )

        // Espacio entre el título de la descripción y la descripción en sí
        Spacer(modifier = Modifier.height(8.dp))

        // Muestra la descripción
        Text(
            text = descripcion,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
    }
}


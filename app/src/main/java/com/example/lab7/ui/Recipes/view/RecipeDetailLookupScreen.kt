package com.example.lab7.ui.Recipes.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.lab7.Networking.Response.MealInstruction

@Composable
fun RecipeDetailLookupScreen(recipeName: String, navController: NavController) {
    val viewModel: RecipesViewModel = viewModel()
    val instructions by viewModel.instructions.collectAsState()

    LaunchedEffect(recipeName) {
        viewModel.getInstructions(recipeName)
    }

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
                painter = rememberImagePainter(data = instructions?.imageUrl),
                contentDescription = "Imagen de la receta",
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

        // Muestra el nombre de la receta
        instructions?.name?.let {
            Text(
                text = it,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        // Espacio entre el nombre y el título de las instrucciones
        Spacer(modifier = Modifier.height(8.dp))

        // Título "Instrucciones"
        Text(
            text = "Instrucciones",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 16.dp)
        )

        // Espacio entre el título de las instrucciones y las instrucciones en sí
        Spacer(modifier = Modifier.height(8.dp))

        // Muestra las instrucciones
        instructions?.let {
            Text(
                text = it.instructions,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}
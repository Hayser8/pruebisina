package com.example.lab7.ui.Profile.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab7.R
import com.example.lab7.ui.Profile.model.CardItem

// Función Composable para mostrar el perfil del usuario.
@Composable
fun UserProfile() {
    // Define una columna que ocupa todo el tamaño disponible y tiene un fondo blanco.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Caja que ocupa el 40% del alto disponible.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        ) {
            // Muestra una imagen de fondo.
            Image(
                painter = painterResource(id = R.drawable.party),
                contentDescription = "Profile Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Columna centrada que muestra una imagen de perfil y el nombre de usuario.
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                // Imagen de perfil.
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                // Espaciador para separación.
                Spacer(modifier = Modifier.height(8.dp))
                // Texto con el nombre de usuario.
                Text(
                    text = "Nombre de Usuario",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
        // Espaciador para separación.
        Spacer(modifier = Modifier.height(20.dp))

        // Lista de elementos de tarjeta para el perfil.
        val cardItems = listOf(
            CardItem("Editar perfil", R.drawable.profile, false),
            CardItem("Reiniciar Contraseña", R.drawable.pass, false),
            CardItem("Notificaciones", R.drawable.notif, true),
            CardItem("Favoritos", R.drawable.fave, false)
        )

        // Itera sobre cada elemento de la tarjeta y lo muestra.
        cardItems.forEach { cardItem ->
            ProfileCardItemView(cardItem)
            // Espaciador entre elementos.
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
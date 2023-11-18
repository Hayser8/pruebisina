package com.example.lab7.ui.Login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lab7.Navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {
    // Estos son estados para almacenar el email y la contraseña ingresados por el usuario.
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Se define la estructura de la pantalla de inicio de sesión.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Texto del título.
        Text(
            text = "Iniciar sesión",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Campo para ingresar el email/usuario.
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Usuario") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Campo para ingresar la contraseña.
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Acciones a realizar cuando el usuario presiona "Done" en el teclado.
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Botón de inicio de sesión.
        Button(
            onClick = {
                // Lógica para validar y navegar si el inicio de sesión es correcto.
                navController.navigate(Screen.EventosMax.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Iniciar sesión")
        }
    }
}
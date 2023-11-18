package com.example.lab7.ui.Profile.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Vista Composable para un botón de alternancia (toggle).
@Composable
fun ToggleButtonView() {
    Switch(
        checked = false, // Valor por defecto (no activado).
        onCheckedChange = {}, // Acción al cambiar estado (aquí no se define ninguna acción).
        modifier = Modifier.padding(4.dp)
    )
}
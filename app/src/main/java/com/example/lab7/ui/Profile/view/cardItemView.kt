package com.example.lab7.ui.Profile.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab7.R
import com.example.lab7.ui.Profile.model.CardItem


// Vista Composable para mostrar un elemento individual de la tarjeta en el perfil.
@Composable
fun ProfileCardItemView(cardItem: CardItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(0.dp) // Esquinas redondeadas (aquí se define 0, lo que significa esquinas cuadradas).
    ) {
        Row(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Muestra una imagen para el elemento de la tarjeta.
            Image(
                painter = painterResource(id = cardItem.imageResourceId),
                contentDescription = "Card Image",
                modifier = Modifier
                    .size(18.dp)
            )
            // Espaciador para separación.
            Spacer(modifier = Modifier.width(16.dp))

            // Texto para el título del elemento de la tarjeta.
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            ) {
                Text(
                    text = cardItem.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            // Dependiendo de si el elemento tiene un botón de alternancia o no, muestra el botón o una imagen.
            if (cardItem.hasToggleButton) {
                com.example.lab7.ui.Profile.view.ToggleButtonView()
            } else {
                Image(
                    painter = painterResource(id = R.drawable.triangle),
                    contentDescription = "Small Image",
                    modifier = Modifier
                        .size(16.dp)
                )
            }
        }
    }
}

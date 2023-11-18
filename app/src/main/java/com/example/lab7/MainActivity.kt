package com.example.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab7.Navigation.NavigationHost
import com.example.lab7.R
import com.example.lab7.ui.Event.model.Event
import com.example.lab7.ui.Lugares.model.Concierto
import com.example.lab7.ui.Meals.view.MealsCategoriesScreen
import com.example.lab7.ui.theme.Lab7Theme

class MainActivity : ComponentActivity() {
    // Datos de muestra
    val sampleEvents = listOf(
        Event("Billie Eilish", R.drawable.billiemiamor, "Happier Than Ever World Tour", "10 de Octubre", "8 PM"),
        Event("Bad Bunny", R.drawable.bbbello, "Un Verano Sin Ti World Tour", "10 de Octubre", "8 PM"),
        Event("C. Tangana", R.drawable.ctangana, "El Madrileño Presenta", "10 de Octubre", "8 PM") ,
        Event("Miley Cyrus", R.drawable.mileybaby, "Endless Summer Now Available", "10 de Octubre", "8 PM"),
        Event("SZA", R.drawable.szan, "Your ex better be hiding", "10 de Octubre", "8 PM"),
        Event("Labrinth", R.drawable.labrinth, "Ready to feel the euphoria vibe?", "10 de Octubre", "8 PM"),
    )

    val conciertos = listOf(
        Concierto("Billie Eilish", R.drawable.billiemiamor, "Ciudad Cayala", R.drawable.triangle),
        Concierto("Bad Bunny", R.drawable.bbbello, "Ciudad Cayala", R.drawable.triangle),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab7Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationHost(events = sampleEvents, concerts = conciertos)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab7Theme {
        Greeting("Android")
    }
}
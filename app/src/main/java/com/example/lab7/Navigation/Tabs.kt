package com.example.lab5

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.lab7.R
import com.example.lab7.ui.Event.model.Event
import com.example.lab7.ui.Event.view.InfoConciertosScreen
import com.example.lab7.ui.Favorites.view.FavoritesContent
import com.example.lab7.ui.Lugares.model.Concierto
import com.example.lab7.ui.Lugares.view.InfoConciertos
import com.example.lab7.ui.Meals.view.MealsCategoriesScreen
import com.example.lab7.ui.Profile.view.UserProfile
import com.example.lab7.ui.Recipes.view.RecipesScreen

// Definición de una enumeración para las distintas pantallas/tabuladores de la aplicación.
enum class TabScreen(val title: String, val icon: Int) {
    Eventos("Eventos", R.drawable.homeicon),
    Lugares("Lugares", R.drawable.locationicon),
    Perfil("Perfil", R.drawable.profileicon),
    Favoritos("Favoritos", R.drawable.staricon),
    Meals("Comidas", R.drawable.foodicon),
}

// Suprime una advertencia específica sobre el parámetro de relleno en Material3Scaffold y opta por usar APIs experimentales.
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TodoEventoApp(
    events: List<Event>,        // Lista de eventos
    concerts: List<Concierto>,  // Lista de conciertos
    navController: NavController // Controlador de navegación para navegar entre pantallas
) {
    // Estado para recordar la pestaña seleccionada, inicialmente es "Eventos".
    var selectedTab by remember { mutableStateOf<TabScreen>(TabScreen.Eventos) }

    // Recupera todos los valores de la enumeración TabScreen.
    val tabs = TabScreen.values()

    // Define un esqueleto para la aplicación.
    Scaffold(
        content = {
            // Columna que ocupa todo el espacio disponible.
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Decide qué pantalla mostrar basándose en la pestaña/tab seleccionada.
                when (selectedTab) {
                    TabScreen.Eventos -> InfoConciertosScreen(events = events, navController = navController)
                    TabScreen.Lugares -> InfoConciertos(concerts)
                    TabScreen.Perfil -> UserProfile()
                    TabScreen.Favoritos -> FavoritesContent()
                    TabScreen.Meals -> MealsCategoriesScreen(navController = navController)
                }
            }
        },
        bottomBar = {
            // Define la barra inferior de la aplicación.
            BottomAppBar(
                containerColor = Color.Black // Color de fondo de la barra inferior.
            ) {
                // Barra de navegación inferior.
                BottomNavigation(
                    modifier = Modifier
                        .height(56.dp)
                        .background(Color.DarkGray)
                ) {
                    // Itera sobre todas las pestañas/tabs y crea un ítem para cada una.
                    tabs.forEach { tab ->
                        BottomNavigationItem(
                            selected = tab == selectedTab,
                            onClick = { selectedTab = tab }, // Cambia la pestaña/tab seleccionada cuando se hace clic.
                            icon = {
                                // Define el ícono de la pestaña/tab.
                                Image(
                                    painter = painterResource(id = tab.icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            },
                            label = {
                                // Define el título de la pestaña/tab y cambia el color según si está seleccionada o no.
                                Text(
                                    text = tab.title,
                                    color = if (tab == selectedTab) Color.White else Color.DarkGray,
                                    fontSize = 11.sp  // Ajusta el tamaño del texto aquí.
                                )
                            },
                            alwaysShowLabel = true, // Muestra el título de la pestaña/tab siempre.
                            selectedContentColor = Color.White,      // Color del contenido cuando está seleccionado.
                            unselectedContentColor = Color.DarkGray  // Color del contenido cuando no está seleccionado.
                        )
                    }
                }
            }
        }
    )
}









package com.example.lab7.Navigation


import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab5.DetalleComposable
import com.example.lab5.TodoEventoApp


import com.example.lab7.ui.Event.model.Event
import com.example.lab7.ui.Login.Login
import com.example.lab7.ui.Lugares.model.Concierto
import com.example.lab7.ui.Recipes.view.RecipeDetailLookupScreen
import com.example.lab7.ui.Recipes.view.RecipesScreen

@Composable
fun NavigationHost(events: List<Event>, concerts: List<Concierto>) {
    // Controlador de navegación de Compose para gestionar las transiciones entre pantallas.
    val navController = rememberNavController()

    // Definición de las rutas y sus respectivas pantallas.
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            Login(navController = navController)
        }
        composable(Screen.EventosMax.route) {
            TodoEventoApp(events = events, concerts = concerts, navController)
        }
        composable("detalle/{title}/{fecha}/{hora}/{description}/{imageRes}") { backStackEntry ->
            // Extracción de argumentos pasados en la ruta.
            val titulo = backStackEntry.arguments?.getString("title") ?: ""
            val fecha = backStackEntry.arguments?.getString("fecha") ?: ""
            val hora = backStackEntry.arguments?.getString("hora") ?: ""
            val descripcion = backStackEntry.arguments?.getString("description") ?: ""
            val fotica = backStackEntry.arguments?.getString("imageRes")?.toIntOrNull() ?: 0

            // Llamada a la función composable que muestra el detalle.
            DetalleComposable(titulo, fecha, hora, descripcion, fotica, navController)
        }
        composable("recipesByCategory/{categoryName}") { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
            RecipesScreen(categoryName, navController)
        }
        composable("recipeDetailLookup/{recipeName}") { backStackEntry ->
            val recipeName = backStackEntry.arguments?.getString("recipeName") ?: ""
            RecipeDetailLookupScreen(recipeName, navController)
        }


    }
}

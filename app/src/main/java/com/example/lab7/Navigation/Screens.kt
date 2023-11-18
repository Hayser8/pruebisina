package com.example.lab7.Navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object EventosMax : Screen("EventosMax+")
    object MealDetails : Screen("mealDetails/{mealId}/{mealName}/{mealDescription}/{mealImage}")
    object MealsCategories : Screen("Categorias")
    object RecipesByCategory : Screen("recipesByCategory/{categoryName}")
    object RecipeDetailLookup : Screen("recipeDetailLookup/{recipeName}")

}

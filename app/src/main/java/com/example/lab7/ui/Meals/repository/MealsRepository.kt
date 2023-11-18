package com.example.lab7.ui.Meals.repository

import android.util.Log
import com.example.lab7.Networking.MealsWebService
import com.example.lab7.Networking.Response.MealDetail
import com.example.lab7.Networking.Response.MealDetailResponse
import com.example.lab7.Networking.Response.MealInstruction
import com.example.lab7.Networking.Response.MealInstructionResponse
import com.example.lab7.Networking.Response.MealResponse
import com.example.lab7.Networking.Response.MealsCategoriesResponse
import com.google.firebase.firestore.FirebaseFirestore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    private val db = FirebaseFirestore.getInstance()

    fun getMeals(successCallback: (List<MealResponse>) -> Unit) {
        db.collection("categories").get()
            .addOnSuccessListener { documents ->
                val mealsList = documents.map { document ->
                    document.toObject(MealResponse::class.java)
                }
                successCallback(mealsList)
            }
            .addOnFailureListener { exception ->
                // Manejo de errores
            }
    }
    fun getRecipes(category: String, successCallback: (List<MealDetail>) -> Unit) {
        db.collection("meals").whereEqualTo("category", category).get()
            .addOnSuccessListener { documents ->
                val recipesList = documents.toObjects(MealDetail::class.java)
                Log.d("getRecipes", "Number of recipes fetched: ${recipesList.size}")
                for (recipe in recipesList) {
                    Log.d("getRecipes", "Recipe: ${recipe.name}")
                }
                successCallback(recipesList)
            }
            .addOnFailureListener { exception ->
                Log.e("getRecipes", "Error fetching recipes", exception)
            }
    }
    fun getInstructions(recipeName: String, successCallback: (MealInstruction?) -> Unit, failureCallback: (Exception) -> Unit) {
        db.collection("instructions")
            .whereEqualTo("name", recipeName)
            .limit(1)
            .get()
            .addOnSuccessListener { querySnapshot ->
                val mealInstruction = querySnapshot.documents.firstOrNull()?.toObject(MealInstruction::class.java)
                successCallback(mealInstruction)
            }
            .addOnFailureListener { exception ->
                failureCallback(exception)
            }
    }
}
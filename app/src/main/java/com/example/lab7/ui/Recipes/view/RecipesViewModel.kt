package com.example.lab7.ui.Recipes.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7.Networking.Response.MealDetail
import com.example.lab7.Networking.Response.MealDetailResponse
import com.example.lab7.Networking.Response.MealInstruction
import com.example.lab7.Networking.Response.MealInstructionResponse
import com.example.lab7.ui.Meals.repository.MealsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    private val _recipes = MutableStateFlow<List<MealDetail>>(emptyList())
    val recipes: StateFlow<List<MealDetail>> = _recipes

    fun getRecipes(category: String) {
        viewModelScope.launch {
            repository.getRecipes(category) { recipesList ->
                Log.d("RecipesViewModel", "Recipes: ${recipesList.joinToString { it.name }}")
                _recipes.value = recipesList
            }
        }
    }
    private val _instructions = MutableStateFlow<MealInstruction?>(null)
    val instructions: StateFlow<MealInstruction?> = _instructions

    fun getInstructions(recipeName: String) {
        viewModelScope.launch {
            repository.getInstructions(recipeName,
                successCallback = { instruction ->
                    _instructions.value = instruction
                },
                failureCallback = { exception ->
                    // Manejar el error
                }
            )
        }
    }

}

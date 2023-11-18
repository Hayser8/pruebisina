package com.example.lab7.ui.Meals.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7.Networking.Response.MealResponse
import com.example.lab7.Networking.Response.MealsCategoriesResponse
import com.example.lab7.ui.Meals.repository.MealsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {

    private val _meals = MutableStateFlow<List<MealResponse>>(emptyList())
    val meals: StateFlow<List<MealResponse>> = _meals

    init {
        fetchMeals()
    }

    private fun fetchMeals() {
        viewModelScope.launch {
            repository.getMeals { mealsList ->
                _meals.value = mealsList
            }
        }
    }
}
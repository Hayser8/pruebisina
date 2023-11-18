package com.example.lab7.Networking

import com.example.lab7.Networking.Response.MealsCategoriesResponse
import com.example.lab7.Networking.Response.MealDetailResponse
import com.example.lab7.Networking.Response.MealInstructionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    fun getMeals(): Call<MealsCategoriesResponse>

    @GET("filter.php")
    fun getRecipes(@Query("c") category: String): Call<MealDetailResponse>

    @GET("lookup.php")
    fun getMealInstructions(@Query("i") recipeId: String): Call<MealInstructionResponse>
}

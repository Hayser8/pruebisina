package com.example.lab7.Networking.Response

import com.google.firebase.firestore.PropertyName
import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(val categories: List<MealResponse>)

data class MealDetailResponse(val meals: List<MealDetail>)

data class MealInstructionResponse(val meals: List<MealInstruction>)

data class MealResponse(
    @PropertyName("id") var id: String = "",
    @PropertyName("name") var name: String = "",
    @PropertyName("description") var description: String = "",
    @PropertyName("imageUrl") var imageUrl: String = ""
)


data class MealDetail(
    @PropertyName("id") val id: String = "",
    @PropertyName("name") val name: String = "",
    @PropertyName("imageUrl") val imageUrl: String = "",
    @PropertyName("category") val category: String = ""
)

data class MealInstruction(
    @PropertyName("id") val id: String = "",
    @PropertyName("name") val name: String = "",
    @PropertyName("instructions") val instructions: String = "",
    @PropertyName("imageUrl") val imageUrl: String = ""
)


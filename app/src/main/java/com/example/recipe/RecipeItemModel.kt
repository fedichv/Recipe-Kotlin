package com.example.recipe

open class RecipeItemModel

class DishItemModel(
    val dish: String,
    val cookingTime: String,
    val photoProfile: Int,
    val nameUser: String,
    val numberOfLikes: String,
    val description: String
) : RecipeItemModel()

class HeaderViewModel(
    val ingredientsAndSteps: String
) : RecipeItemModel()

class IngredientsUsedItemModel(
    val ingredients: String
) : RecipeItemModel()

class StepsItemModel(
    val stepNum: String,
    val stepDescription: String,
    val stepImage: Int
) : RecipeItemModel()
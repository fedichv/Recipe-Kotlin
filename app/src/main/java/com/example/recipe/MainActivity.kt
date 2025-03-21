package com.example.recipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recipeView = findViewById<RecyclerView>(R.id.recipeView)

        val dishName = intent.getStringExtra("DISH") ?: "0"
        val description = intent.getStringExtra("DESCRIPTION") ?: "0"
        val ing = intent.getStringExtra("ING") ?: "0"
        val steps = intent.getStringExtra("STEPS") ?: "0"

        var stepCount = 0

        var ingredientsUsedList: List<String> = ing.split(";")
        var stepsList: List<String> = steps.split("#")

        var recipeItems = arrayOf(
            DishItemModel(dishName, "30 мин",
                R.drawable.user_test, "Иван", "120", description),
            HeaderViewModel("Ingredients")
        )

        for (ingredient in ingredientsUsedList) {
            recipeItems += IngredientsUsedItemModel(ingredient)
        }

        for (step in stepsList) {
            val stepsImageList: List<String> = step.split("$")
            stepCount += 1
            if (stepsImageList.size == 2) {
                val stepDescription = stepsImageList[0]
                val imageUrl = stepsImageList[1]
                recipeItems += StepsItemModel(stepCount.toString(), stepDescription, imageUrl)
            }
        }
//qqq$0# wwww$1
        val adapter = RecipeAdapter(recipeItems)

        recipeView.layoutManager = LinearLayoutManager(this)
        recipeView.adapter = adapter
    }
}

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

        val dishName = intent.getStringExtra("DISH")  ?: "0"
        val description = intent.getStringExtra("DESCRIPTION") ?: "0"
        val ing = intent.getStringExtra("ING") ?: "0"
        val steps = intent.getStringExtra("STEPS") ?: "0"

        var stepCount = 0

        var ingredientsUsedList: List<String> = ing.split(";")
        var stepsList: List<String> = steps.split("#")
        val pictures = arrayOf(R.drawable.one,R.drawable.two,R.drawable.three)


        var recipeItems = arrayOf(
            DishItemModel(dishName, "30 мин", R.drawable.user_test, "Иван", "120", description),
            HeaderViewModel("Ingredients"),

//            StepsItemModel("1", "Замесить тесто и дать ему подняться", R.drawable.image_step),
//            StepsItemModel("2", "Раскатать тесто и смазать томатным соусом", R.drawable.image_step),
//            StepsItemModel("3", "Добавить сыр и остальные ингредиенты", R.drawable.image_step),
//            StepsItemModel("4", "Выпекать в духовке при 220°C 15-20 минут", R.drawable.image_step),
        )

        for (ingredient in ingredientsUsedList) {
            recipeItems += IngredientsUsedItemModel(ingredient)
        }
        for (step in stepsList) {
            val stepsImageList: List<String> = step.split("$")
            stepCount += 1
            recipeItems += StepsItemModel(stepCount.toString(), stepsImageList[0], pictures[stepsImageList[1].toInt()])
        }
        //qqqqq$0# wwww$1#

        val adapter = RecipeAdapter(recipeItems)

        recipeView.layoutManager = LinearLayoutManager(this)
        recipeView.adapter = adapter
    }
}
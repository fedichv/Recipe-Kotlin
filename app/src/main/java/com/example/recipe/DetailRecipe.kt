package com.example.recipe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class DetailRecipe: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_recipe1)

        val et_dish_name = findViewById<EditText>(R.id.et_dish_name)
        val et_description = findViewById<EditText>(R.id.et_description)
        val et_ingredients = findViewById<EditText>(R.id.et_ingredients)
        val et_steps = findViewById<EditText>(R.id.et_steps)
        val btn_add = findViewById<Button>(R.id.btn_add)

        btn_add.setOnClickListener() {
            val dish_name = et_dish_name.text.toString()
            val description = et_description.text.toString()
            val ingredient = et_ingredients.text.toString()
            val steps = et_steps.text.toString()


            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("DISH", dish_name)
            intent.putExtra("DESCRIPTION", description)
            intent.putExtra("ING", ingredient)
            intent.putExtra("STEPS", steps)

            startActivity(intent)
        }
    }
}
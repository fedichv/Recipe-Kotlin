package com.example.recipe

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeaderView(itemView: View): RecyclerView.ViewHolder(itemView) {
    val ingredientsAndSteps: TextView = itemView.findViewById(R.id.IngredientsAndSteps)
}
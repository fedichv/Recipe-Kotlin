package com.example.recipe

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IngredientsUsed(itemView: View): RecyclerView.ViewHolder(itemView) {
    val ingredients: TextView = itemView.findViewById(R.id.igredients)
}
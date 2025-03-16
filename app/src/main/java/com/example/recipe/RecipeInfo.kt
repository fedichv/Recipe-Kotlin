package com.example.recipe

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeInfo(itemView: View): RecyclerView.ViewHolder(itemView) {
    val dish: TextView = itemView.findViewById(R.id.dish)
    val cookingTime: TextView = itemView.findViewById(R.id.cookingTime)
    val photoProfile: ImageView = itemView.findViewById(R.id.photoProfile)
    val nameUser: TextView = itemView.findViewById(R.id.nameUser)
    val numberOfLikes: TextView = itemView.findViewById(R.id.numberOfLikes)
    val description: TextView = itemView.findViewById(R.id.description)
}
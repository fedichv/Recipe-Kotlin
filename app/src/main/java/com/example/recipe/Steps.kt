package com.example.recipe

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Steps(itemView: View): RecyclerView.ViewHolder(itemView) {
    val stepNum: TextView = itemView.findViewById(R.id.stepNum)
    val stepDescription: TextView = itemView.findViewById(R.id.stepDescription)
    val stepImage: ImageView = itemView.findViewById(R.id.stepImage)
}

package com.example.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(val items: Array<RecipeItemModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if(viewType == 0) {
            val itemView = inflater.inflate(R.layout.recipe_info, parent, false)
            return RecipeInfo(itemView)
        } else if(viewType == 1) {
            val itemView = inflater.inflate(R.layout.header, parent, false)
            return HeaderView(itemView)
        } else if(viewType == 2) {
            val itemView = inflater.inflate(R.layout.ingredients_used, parent, false)
            return IngredientsUsed(itemView)
        } else if(viewType == 3) {
            val itemView = inflater.inflate(R.layout.steps, parent, false)
            return Steps(itemView)
        } else {
            TODO("sdfghjk")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (item is DishItemModel && holder is RecipeInfo) {
            holder.dish.text = item.dish
            holder.cookingTime.text = item.cookingTime
            holder.photoProfile.setImageResource(item.photoProfile)
            holder.nameUser.text = item.nameUser
            holder.numberOfLikes.text = item.numberOfLikes
            holder.description.text = item.description
        } else if (item is HeaderViewModel && holder is HeaderView) {
            holder.ingredientsAndSteps.text = item.ingredientsAndSteps
        } else if (item is IngredientsUsedItemModel && holder is IngredientsUsed) {
            holder.ingredients.text = item.ingredients
        } else if (item is StepsItemModel && holder is Steps) {
            holder.stepNum.text = item.stepNum
            holder.stepDescription.text = item.stepDescription
            holder.stepImage.setImageResource(item.stepImage)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return when (item) {
            is DishItemModel -> 0
            is HeaderViewModel -> 1
            is IngredientsUsedItemModel -> 2
            is StepsItemModel -> 3
            else -> 4
        }
    }
}
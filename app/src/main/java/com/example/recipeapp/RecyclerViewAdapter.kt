package com.example.recipeapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val mContext: Context,
    private var mData: List<Recipes>
) : RecyclerView.Adapter<RecyclerViewAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.cardview_recipe, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.recipeTitle.text = mData[position].recipeName
        holder.imgRecipeThumbnail.setImageResource(mData[position].thumbnail)

        holder.cardView.setOnClickListener {
            val intent = Intent(mContext, RecipeActivity::class.java).apply {
                putExtra("RecipeName", mData[position].recipeName)
                putExtra("RecipeIngredients", mData[position].recipeIngredients)
                putExtra("RecipeMethodTitle", mData[position].recipeMethodTitle)
                putExtra("Recipe", mData[position].recipe)
                putExtra("Thumbnail", mData[position].thumbnail)
            }
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }
    fun updateList(newList: ArrayList<Recipes>) {
        mData = newList
        notifyDataSetChanged()
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeTitle: TextView = itemView.findViewById(R.id.recipe_text)
        val imgRecipeThumbnail: ImageView = itemView.findViewById(R.id.recipe_img_id)
        val cardView: CardView = itemView.findViewById(R.id.cardview_id)
    }
}

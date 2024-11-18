package com.example.recipeapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeActivity : AppCompatActivity() {

    private lateinit var mRecipeName: TextView
    private lateinit var mRecipeIngredients: TextView
    private lateinit var mRecipeMethodTitle: TextView
    private lateinit var imgRecipe : ImageView
    private lateinit var mRecipe: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)


        mRecipeName = findViewById(R.id.text_recipe)
        mRecipeIngredients = findViewById(R.id.ingredients)
        mRecipeMethodTitle = findViewById(R.id.method)
        mRecipe = findViewById(R.id.recipe)
        imgRecipe = findViewById(R.id.imgRecipe)

        val intent: Intent = intent
        val title = intent.extras?.getString("RecipeName")
        val ingredients = intent.extras?.getString("RecipeIngredients")
        val methodTitle = intent.extras?.getString("RecipeMethodTitle")
        val recipe = intent.extras?.getString("Recipe")
        val img = intent.extras?.getInt("Thumbnail")

        mRecipeName.text = title
        mRecipeIngredients.text = ingredients
        mRecipeMethodTitle.text = methodTitle
        mRecipe.text = recipe
        imgRecipe.setImageResource(img ?: -1)

    }
}

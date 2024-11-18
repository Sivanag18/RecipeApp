package com.example.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var myAdapter: RecyclerViewAdapter
    private val recipes1 = mutableListOf<Recipes>()
    private lateinit var recipeSearchView: SearchView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recipes1.add(
            Recipes(
                "Pulihora",
                "2 cups rice, 1/4 cup tamarind pulp, 1/4 cup peanuts, 1 tablespoon oil, 1 teaspoon mustard seeds, 1 teaspoon turmeric powder, 1 tablespoon green chilies, 1/4 teaspoon hing, curry leaves, salt to taste",
                "Method",
                "Pulihora, also known as Tamarind Rice, is a traditional South Indian rice dish. Cook rice and cool it down. In a pan, heat oil, add mustard seeds, turmeric, green chilies, and curry leaves. Add tamarind pulp and cook for a few minutes. Add peanuts and mix with the rice. Season with salt and serve hot.",
                "Pulihora",
                R.drawable.pulihora
            )
        )

        recipes1.add(
            Recipes(
                "Bonda",
                "1 cup boiled potatoes, 1/2 cup chopped onions, 1 teaspoon ginger, 1/2 teaspoon green chilies, 1 teaspoon mustard seeds, 1/2 teaspoon turmeric powder, curry leaves, 1 cup besan (gram flour), salt to taste, oil for frying",
                "Method",
                "Bonda is a famous South Indian snack made with mashed potatoes, spiced with mustard, ginger, and green chilies, and deep-fried in a crispy batter. To make the filling, heat oil in a pan and fry the mustard seeds, ginger, and green chilies. Mix with boiled potatoes, salt, and curry leaves. Form into balls. Coat with besan and fry in hot oil until golden brown.",
                "Bonda",
                R.drawable.bonda
            )
        )

        recipes1.add(
            Recipes(
                "Dosa",
                "3 cups rice, 1 cup urad daal (split, skinless black gram), 3/4 teaspoon fenugreek seeds, salt to taste, vegetable oil",
                "Method",
                "Wash and soak the rice, urad daal, and fenugreek overnight. Grind into a smooth batter and let it ferment for 12-24 hours. Heat a non-stick pan, pour a ladle of batter, spread thinly, and cook until crispy. Fold and serve hot with chutneys and sambar.",
                "Dosa",
                R.drawable.dosa
            )
        )

        recipes1.add(
            Recipes(
                "Idly",
                "2 cups rice, 1 cup urad daal (split black gram), 1/2 teaspoon fenugreek seeds, water, salt to taste",
                "Method",
                "Wash and soak rice, urad daal, and fenugreek seeds for 4-6 hours. Grind the mixture into a smooth batter, add salt, and let it ferment for 8-12 hours. Grease the idly molds and steam the batter in a pressure cooker or idly cooker for about 10-12 minutes. Serve hot with chutneys or sambar.",
                "Idly",
                R.drawable.idly
            )
        )

        recipes1.add(
            Recipes(
                "Veg Biryani",
                "2 cups basmati rice, 1 onion sliced, 1 tomato chopped, 1 cup mixed vegetables (carrot, beans, peas), 1/2 cup yogurt, 1 tablespoon ginger-garlic paste, 2 teaspoons garam masala, 1/2 teaspoon turmeric, 1 teaspoon cumin seeds, bay leaf, cinnamon, cloves, salt to taste, oil",
                "Method",
                "In a pan, heat oil, and sauté onions until golden brown. Add ginger-garlic paste, chopped tomatoes, and sauté. Add mixed vegetables, garam masala, turmeric, and cook for a few minutes. Add soaked basmati rice and water, and cook until rice is tender. Garnish with coriander and serve hot.",
                "Veg Biryani",
                R.drawable.vegbiryani
            )
        )

        recipes1.add(
            Recipes(
                "Chicken Biryani",
                "2 cups basmati rice, 500g chicken, 1 onion sliced, 1 tomato chopped, 1/2 cup yogurt, 1 tablespoon ginger-garlic paste, 2 teaspoons biryani masala, 1/2 teaspoon turmeric, 1 teaspoon cumin seeds, bay leaf, cinnamon, cloves, salt to taste, oil",
                "Method",
                "Marinate the chicken with yogurt, ginger-garlic paste, biryani masala, turmeric, and salt for at least 1 hour. In a pan, sauté onions, then add tomatoes and cook. Add the marinated chicken and cook for 10-15 minutes. Add soaked basmati rice, water, and cook until rice is done. Garnish with mint leaves and serve.",
                "Chicken Biryani",
                R.drawable.chicken_biryani
            )
        )

        recipes1.add(
            Recipes(
                "Mutton Biryani",
                "2 cups basmati rice, 500g mutton, 1 onion sliced, 1 tomato chopped, 1/2 cup yogurt, 1 tablespoon ginger-garlic paste, 2 teaspoons biryani masala, 1/2 teaspoon turmeric, 1 teaspoon cumin seeds, bay leaf, cinnamon, cloves, salt to taste, oil",
                "Method",
                "Marinate the mutton with yogurt, ginger-garlic paste, biryani masala, turmeric, and salt for at least 1 hour. In a pan, sauté onions, then add tomatoes and cook. Add the marinated mutton and cook for 30-40 minutes. Add soaked basmati rice, water, and cook until rice is done. Garnish with coriander and serve.",
                "Mutton Biryani",
                R.drawable.mutton_biryani
            )
        )

        recipes1.add(
            Recipes(
                "Fish Fry",
                "500g fish fillets, 1 tablespoon ginger-garlic paste, 1 teaspoon red chili powder, 1/2 teaspoon turmeric powder, 1 tablespoon lemon juice, salt to taste, oil for frying",
                "Method",
                "Marinate fish fillets with ginger-garlic paste, red chili powder, turmeric, lemon juice, and salt for 30 minutes. Heat oil in a pan and shallow fry the fish until crispy and golden brown on both sides. Serve hot with lemon wedges.",
                "Fish Fry",
                R.drawable.fish_fry
            )
        )

        recipes1.add(
            Recipes(
                "Prawns Biryani",
                "2 cups basmati rice, 500g prawns, 1 onion sliced, 1 tomato chopped, 1/2 cup yogurt, 1 tablespoon ginger-garlic paste, 2 teaspoons biryani masala, 1/2 teaspoon turmeric, 1 teaspoon cumin seeds, bay leaf, cinnamon, cloves, salt to taste, oil",
                "Method",
                "Marinate prawns with yogurt, ginger-garlic paste, biryani masala, turmeric, and salt for at least 30 minutes. In a pan, sauté onions, add tomatoes and cook. Add marinated prawns and cook for 5-7 minutes. Add soaked basmati rice, water, and cook until rice is done. Garnish with mint leaves and serve.",
                "Prawns Biryani",
                R.drawable.prawns_biryani
            )
        )

        // Set up RecyclerView
        myRecyclerView = findViewById(R.id.recyclerView_id)
        recipeSearchView = findViewById(R.id.recipe_search_view)

        myAdapter = RecyclerViewAdapter(this, recipes1)
        myRecyclerView.layoutManager = GridLayoutManager(this, 1)
        myRecyclerView.adapter = myAdapter

        recipeSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = filterRecipes(newText)
                myAdapter.updateList(filteredList)
                return true
            }
        })
    }

    private fun filterRecipes(query: String?): ArrayList<Recipes> {
        val filteredList = ArrayList<Recipes>()
        if (!query.isNullOrEmpty()) {
            for (recipe in recipes1) {
                if (recipe.name.contains(query, ignoreCase = true)) {
                    filteredList.add(recipe)
                }
            }
        } else {
            filteredList.addAll(recipes1) // If no query, show all recipes
        }
        return filteredList
    }
}

package com.icanerdogan.videogameslibrary.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.icanerdogan.videogameslibrary.R
import com.icanerdogan.videogameslibrary.databinding.ActivityMainBinding
import com.icanerdogan.videogameslibrary.model.DetailGame

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    lateinit var favoriteGameList : ArrayList<DetailGame>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        favoriteGameList = ArrayList()

        val navController = findNavController(R.id.fragmentContainerView)
        val bottomNavigationView = mainBinding.bottomNavigationView
        bottomNavigationView.setupWithNavController(navController)
        }

}
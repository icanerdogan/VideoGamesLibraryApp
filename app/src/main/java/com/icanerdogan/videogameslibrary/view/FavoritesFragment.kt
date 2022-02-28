package com.icanerdogan.videogameslibrary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.icanerdogan.videogameslibrary.R
import com.icanerdogan.videogameslibrary.databinding.FragmentFavoritesBinding


class FavoritesFragment : Fragment() {
    private lateinit var favoritesBinding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        favoritesBinding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return favoritesBinding.root
    }


}
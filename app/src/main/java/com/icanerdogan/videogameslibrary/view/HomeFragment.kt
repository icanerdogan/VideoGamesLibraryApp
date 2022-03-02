package com.icanerdogan.videogameslibrary.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.icanerdogan.videogameslibrary.adapter.RecyclerViewGameAdapter
import com.icanerdogan.videogameslibrary.databinding.FragmentHomeBinding
import com.icanerdogan.videogameslibrary.model.BaseGame
import com.icanerdogan.videogameslibrary.viewmodel.BasicGameViewModel


class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var basicGameViewModel: BasicGameViewModel

    private val baseGame = BaseGame(arrayListOf())
    private val gameAdapter = RecyclerViewGameAdapter(baseGame)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        basicGameViewModel = ViewModelProvider(this).get(BasicGameViewModel::class.java)

        homeBinding.recyclerViewGames.layoutManager = LinearLayoutManager(context)
        homeBinding.recyclerViewGames.adapter = gameAdapter

        basicGameViewModel.getAllGamesHomeScreen()

    }

}
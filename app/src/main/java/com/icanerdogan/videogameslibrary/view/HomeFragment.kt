package com.icanerdogan.videogameslibrary.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.icanerdogan.videogameslibrary.adapter.RecyclerViewGameAdapter
import com.icanerdogan.videogameslibrary.adapter.ViewPagerAdapter
import com.icanerdogan.videogameslibrary.databinding.FragmentHomeBinding
import com.icanerdogan.videogameslibrary.model.BaseGame
import com.icanerdogan.videogameslibrary.viewmodel.BasicGameViewModel


class HomeFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var viewPager : ViewPager2? = null

    private lateinit var homeBinding: FragmentHomeBinding

    private lateinit var basicGameViewModel: BasicGameViewModel

    private val baseGame = BaseGame(arrayListOf())
    private val gameAdapter = RecyclerViewGameAdapter(baseGame)
    private val viewPagerAdapter = ViewPagerAdapter(baseGame)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recycler View
        recyclerView = homeBinding.recyclerViewGames
        recyclerView?.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        recyclerView?.adapter = gameAdapter

        //View Pager
        viewPager = homeBinding.viewPagerGames
        viewPager?.adapter = viewPagerAdapter

        // View Model
        basicGameViewModel = ViewModelProvider(this).get(BasicGameViewModel::class.java)
        basicGameViewModel.games.observe(viewLifecycleOwner, object : Observer<BaseGame>{
            override fun onChanged(t: BaseGame?) {
                t?.let {
                    setBaseGame(it)
                    setViewPagerGame(it)
                }
            }
        })
        basicGameViewModel.getAllGamesHomeScreen()

    }

    fun setBaseGame(b : BaseGame){
        gameAdapter.updatGameList(b)
    }
    fun setViewPagerGame(b : BaseGame){
        viewPagerAdapter.updateGameList(b)
    }

}
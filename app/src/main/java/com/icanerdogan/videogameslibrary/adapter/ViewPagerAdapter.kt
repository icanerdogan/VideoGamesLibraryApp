package com.icanerdogan.videogameslibrary.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.icanerdogan.videogameslibrary.databinding.ViewpagerscreenBinding
import com.icanerdogan.videogameslibrary.model.BaseGame
import com.icanerdogan.videogameslibrary.view.HomeFragmentDirections

class ViewPagerAdapter(var baseGameList : BaseGame) : RecyclerView.Adapter<ViewPagerAdapter.Page2ViewHolder>() {

    class Page2ViewHolder(val viewpagerscreenBinding: ViewpagerscreenBinding) : RecyclerView.ViewHolder(viewpagerscreenBinding.root){
        init {
            viewpagerscreenBinding.ImageViewPagerPage.setOnClickListener { v : View ->
                val clickedGameID = viewpagerscreenBinding.viewPagerGameID.text.toString().toInt()

                val action = HomeFragmentDirections.actionHomeFragmentToDetailGameFragment(clickedGameID)
                Navigation.findNavController(v).navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.Page2ViewHolder {
        return Page2ViewHolder(ViewpagerscreenBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Page2ViewHolder, position: Int) {
        holder.viewpagerscreenBinding.viewpagergame = baseGameList.baseGameResults[position]

    }

    override fun getItemCount(): Int {
        return baseGameList.baseGameResults.size - 17
    }


    fun updateGameList(gameList : BaseGame){
        this.baseGameList = gameList
        notifyDataSetChanged()
    }
}
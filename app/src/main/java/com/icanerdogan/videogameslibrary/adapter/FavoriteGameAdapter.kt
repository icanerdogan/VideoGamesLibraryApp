package com.icanerdogan.videogameslibrary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.icanerdogan.videogameslibrary.databinding.FavoritesRowLayoutBinding
import com.icanerdogan.videogameslibrary.model.DetailGame
import com.icanerdogan.videogameslibrary.view.FavoritesFragment

class FavoriteGameAdapter(val context: FavoritesFragment, var favoriteGameList: ArrayList<DetailGame>):
    RecyclerView.Adapter<FavoriteGameAdapter.ViewHolder>(){

    class ViewHolder(val favoritesRowLayoutBinding: FavoritesRowLayoutBinding) : RecyclerView.ViewHolder(favoritesRowLayoutBinding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FavoritesRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.favoritesRowLayoutBinding.favoritegame = favoriteGameList[position]

    }

    override fun getItemCount(): Int {
        return favoriteGameList.size
    }


    /*fun updateFavoriteGameList(gameList: DetailGame) {
        this.favoriteGameList.add(gameList)
        notifyDataSetChanged()
    }*/

}
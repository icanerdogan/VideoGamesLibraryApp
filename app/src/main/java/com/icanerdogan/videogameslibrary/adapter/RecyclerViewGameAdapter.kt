package com.icanerdogan.videogameslibrary.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.icanerdogan.videogameslibrary.R
import com.icanerdogan.videogameslibrary.databinding.RowLayoutBinding
import com.icanerdogan.videogameslibrary.model.BaseGame
import com.icanerdogan.videogameslibrary.view.HomeFragmentDirections

class RecyclerViewGameAdapter (var gameList : BaseGame):
    RecyclerView.Adapter<RecyclerViewGameAdapter.ViewHolder>(),
    GameClickListener{

    class ViewHolder(val rowLayoutBinding: RowLayoutBinding) : RecyclerView.ViewHolder(rowLayoutBinding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rowLayoutBinding.basicgame = gameList.baseGameResults[position + 3]
        holder.rowLayoutBinding.listener = this

    }

    override fun getItemCount(): Int {
        return gameList.baseGameResults.size - 3
    }

    override fun onGameClicked(v: View) {
        val clickedGameID = v.findViewById<TextView>(R.id.rowLayoutGameID).text.toString().toInt()

        val action = HomeFragmentDirections.actionHomeFragmentToDetailGameFragment(clickedGameID)
        Navigation.findNavController(v).navigate(action)

    }
    fun updatGameList(gameList : BaseGame){
        this.gameList = gameList
        notifyDataSetChanged()
    }

}

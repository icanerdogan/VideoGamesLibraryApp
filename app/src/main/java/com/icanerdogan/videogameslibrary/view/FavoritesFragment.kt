package com.icanerdogan.videogameslibrary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.icanerdogan.videogameslibrary.adapter.FavoriteGameAdapter
import com.icanerdogan.videogameslibrary.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    private lateinit var favoritesBinding: FragmentFavoritesBinding
    private var favoritesGameRecyclerView: RecyclerView? = null

    private var getFavoriteDetailGameID : Int = 0
    private lateinit var favoriteAdapter : FavoriteGameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        favoritesBinding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return favoritesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // ONCLICK ADD FAVORITE
        favoritesGameRecyclerView = favoritesBinding.favoritesRecyclerView
        favoritesGameRecyclerView?.layoutManager = LinearLayoutManager(this.requireContext(), RecyclerView.VERTICAL, false)
        favoriteAdapter = FavoriteGameAdapter(this, (activity as MainActivity).favoriteGameList)
        favoritesGameRecyclerView?.adapter = favoriteAdapter


        /*arguments?.let {
            getFavoriteDetailGameID = FavoritesFragmentArgs.fromBundle(it).favoriteGamesID
        }*/

        /*favoriteGameViewModel = ViewModelProvider(this).get(FavoriteGameViewModel::class.java)

        favoriteGameViewModel.favoriteGameLiveData.observe(viewLifecycleOwner, object : Observer<FavoriteGame>{
            override fun onChanged(t: FavoriteGame?) {
                t?.let {
                    setFavoriteGame(it)

                }
            }
        })*/
        // favoriteGameViewModel.getFavoriteDataFromAPI(getFavoriteDetailGameID)

        //observeLiveData()

    }

    /*private fun observeLiveData() {
        favoriteGameViewModel.favoriteGameLiveData.observe(viewLifecycleOwner, Observer { game ->
            game?.let {
                //favoriteGameList.add(it)
                //favoriteAdapter.updateFavoriteGameList(arrayListOf(it))
                setFavoriteGame(it)
            }
        })
    }
     */

/*    private fun setFavoriteGame(it: FavoriteGame) {
        favoriteAdapter.updateFavoriteGameList(it)
    }*/


}
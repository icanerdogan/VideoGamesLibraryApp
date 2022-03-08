package com.icanerdogan.videogameslibrary.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.icanerdogan.videogameslibrary.databinding.FragmentDetailGameBinding
import com.icanerdogan.videogameslibrary.model.DetailGame
import com.icanerdogan.videogameslibrary.viewmodel.DetailGameViewModel


class DetailGameFragment : Fragment() {
    private lateinit var binding: FragmentDetailGameBinding
    private lateinit var detailGameViewModel: DetailGameViewModel
    private var getClickedBasicGameID : Int = 0
    private var detailGame : DetailGame? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // FAVORITE ADD CLICK
        binding.detailGameFavoriteButton.setOnClickListener { v : View ->

            detailGame?.let {
                (activity as MainActivity).favoriteGameList.add(it)
            }

            /*val clickedFavoriteGameID = binding.detailFragmentGameID.text.toString().toInt()

            val action = DetailGameFragmentDirections.actionDetailGameFragmentToFavoritesFragment(clickedFavoriteGameID)
            Navigation.findNavController(v).navigate(action)*/
        }


        binding.detailGameTextViewDescription.movementMethod = ScrollingMovementMethod()

        arguments?.let {
            getClickedBasicGameID = DetailGameFragmentArgs.fromBundle(it).detailGameID
        }

        detailGameViewModel = ViewModelProvider(this).get(DetailGameViewModel::class.java)
        detailGameViewModel.getDetailDataFromAPI(getClickedBasicGameID)

        observeLiveData()
    }


    private fun observeLiveData() {
        detailGameViewModel.detailGameLiveData.observe(viewLifecycleOwner, Observer { game ->
            game?.let {
                detailGame = game
                binding.detailgame = it
            }
        })
    }

    /*override fun onGameClicked(v: View) {
        val clickedFavoriteGameID = binding.detailFragmentGameID.text.toString().toInt()

        val action = DetailGameFragmentDirections.actionDetailGameFragmentToFavoritesFragment(clickedFavoriteGameID)
        Navigation.findNavController(v).navigate(action)
    }*/
}
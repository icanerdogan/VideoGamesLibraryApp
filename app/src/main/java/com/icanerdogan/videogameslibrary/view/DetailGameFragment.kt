package com.icanerdogan.videogameslibrary.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.icanerdogan.videogameslibrary.R
import com.icanerdogan.videogameslibrary.databinding.FragmentDetailGameBinding
import com.icanerdogan.videogameslibrary.viewmodel.DetailGameViewModel


class DetailGameFragment : Fragment() {
    private lateinit var binding: FragmentDetailGameBinding
    private lateinit var detailGameViewModel: DetailGameViewModel
    private var getClickedBasicGameID : Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                binding.detailgame = it
            }
        })
    }
}
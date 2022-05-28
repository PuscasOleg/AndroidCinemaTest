package com.example.cinema.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinema.Image_URL
import com.example.cinema.MAIN
import com.example.cinema.R
import com.example.cinema.databinding.FragmentDetailBinding
import com.example.cinema.databinding.FragmentHomePageBinding
import com.example.cinema.models.MovieItemModel
import com.example.cinema.screens.main.HomePageAdapter
import com.example.cinema.screens.main.HomePageViewModel


class DetailFragment : Fragment() {


    private var mBinding: FragmentDetailBinding? = null
    private val binding get() = mBinding!!
    lateinit var currentMovie: MovieItemModel
    private var isFavorite = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)

        currentMovie = arguments?.getSerializable("movie") as MovieItemModel //узнать
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(HomePageViewModel::class.java) //?

        Glide.with(MAIN).load(Image_URL + currentMovie.poster_path).centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground).into(binding.imageDetail)

        binding.movieTitle.text = currentMovie.title
        binding.movieDate.text = currentMovie.release_date
        binding.movieDesc.text = currentMovie.overview



        binding.itemAddFavourite.setOnClickListener {
            if (!isFavorite) {
                binding.itemAddFavourite.setImageResource(R.drawable.ic_baseline_favorite_color)
                isFavorite = true
            } else {
                binding.itemAddFavourite.setImageResource(R.drawable.ic_baseline_favorite)
                isFavorite = false
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()

        mBinding = null
    }

}
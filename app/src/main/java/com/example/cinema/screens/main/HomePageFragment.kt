package com.example.cinema.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.R
import com.example.cinema.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment() {


    private var mBinding: FragmentHomePageBinding? = null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { HomePageAdapter() }  //by lazy схоже с latenit но с возможность val

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentHomePageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(HomePageViewModel::class.java) //?
        recyclerView = binding.recyclerViewMovie
        recyclerView.adapter = HomePageAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()

        mBinding = null
    }


}
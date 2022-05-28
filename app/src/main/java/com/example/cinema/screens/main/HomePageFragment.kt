package com.example.cinema.screens.main

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.MAIN
import com.example.cinema.R
import com.example.cinema.databinding.FragmentHomePageBinding
import com.example.cinema.models.MovieItemModel


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
        setHasOptionsMenu(true)//?
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(HomePageViewModel::class.java) //?
        viewModel.getMovies()
        recyclerView = binding.recyclerViewMovie
        recyclerView.adapter = adapter
        viewModel.myMovies.observe(viewLifecycleOwner) { list ->
            adapter.setList(list.body()!!.results)

        }
    }

    override fun onDestroy() {
        super.onDestroy()

        mBinding = null
    }

    //?
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.item_favorite -> {
                MAIN.navController.navigate(R.id.action_homePageFragment_to_favouriteFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }


    //узнать
    companion object{
        fun clickMovie(model:MovieItemModel){
            val bundle= Bundle() // узнать !!

            bundle.putSerializable("movie",model)
            MAIN.navController.navigate(R.id.action_homePageFragment_to_detailFragment,bundle)
        }
    }

}
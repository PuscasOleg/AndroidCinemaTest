package com.example.cinema.screens.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinema.MAIN
import com.example.cinema.R
import com.example.cinema.models.MovieItemModel
import com.example.cinema.models.MoviesModel
import kotlinx.android.synthetic.main.item_layout_home.view.*


class HomePageAdapter : RecyclerView.Adapter<HomePageAdapter.HomePageViewHolder>() {


    private var movieList =
        emptyList<MovieItemModel>() // возвращает пустой read-only  сериализуемый список

    class HomePageViewHolder(view: View) : RecyclerView.ViewHolder(view)

    //указывает идентивикатор макета для отдельного элемента списка
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomePageViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_home, parent, false) //?
        return HomePageViewHolder(view)
    }

    //связывает используемые текстовые поля в данными
    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: HomePageViewHolder, position: Int) {
        holder.itemView.item_title.text = movieList[position].title
        holder.itemView.item_date.text = movieList[position].release_date

        Glide.with(MAIN).load(movieList[position].poster_path).centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground).into(holder.itemView.item_img)
    }

    // метод для  определения  количества элементов которые надо отобразить
    override fun getItemCount(): Int {
        return movieList.size
    }
}
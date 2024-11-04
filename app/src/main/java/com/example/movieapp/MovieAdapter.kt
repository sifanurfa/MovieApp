package com.example.movieapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemFilmBinding

typealias OnClickMovie = (Movie) -> Unit
class MovieAdapter(private val listMovie : List<Movie>,private val onClickMovie: OnClickMovie) : RecyclerView.Adapter<MovieAdapter.ItemFilmViewHolder>() {
    inner class ItemFilmViewHolder(private val binding: ItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Movie) {
            with(binding) {
                imgFilm.setImageResource(data.gambarFilm)
                txtFilmJudul.text = data.judulFilm
                txtFilmDurasi.text = data.durasiFilm
                txtFilmRating.text = data.ratingFilm
                itemView.setOnClickListener {
                    onClickMovie(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFilmViewHolder {
        val binding =
            ItemFilmBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
        return ItemFilmViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: ItemFilmViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }
}
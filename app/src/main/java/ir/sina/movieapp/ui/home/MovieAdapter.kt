/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package ir.sina.movieapp.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import ir.sina.movieapp.Constants.POSTER_BASEURL
import ir.sina.movieapp.R
import ir.sina.movieapp.data.model.MovieResponse
import ir.sina.movieapp.databinding.ItemMovieBinding

class MovieAdapter(private val onClick: (MovieResponse.Movie) -> Unit) : ListAdapter<MovieResponse.Movie, MovieAdapter.ViewHolder>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<MovieResponse.Movie>() {
        override fun areItemsTheSame(oldItem: MovieResponse.Movie, newItem: MovieResponse.Movie): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: MovieResponse.Movie, newItem: MovieResponse.Movie): Boolean = oldItem == newItem
    }

    inner class ViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MovieResponse.Movie) {
            binding.apply {
                tvMovieTitle.text = item.title
                tvPoint.text = item.vote_average.toString()
                val moviePosterUrl = POSTER_BASEURL + item.poster_path
                Log.e("TAG", "bind: $moviePosterUrl", )
                imgMovie.load(moviePosterUrl) {
                    crossfade(true)
                    placeholder(R.drawable.eli)
                    scale(Scale.FILL)
                }

                tvLanguage.text = item.original_language
                tvDate.text = item.release_date
                root.setOnClickListener {
                    onClick(item)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder=
        ViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    private val differCallback = object : DiffUtil.ItemCallback<MovieResponse.Movie>() {
        override fun areItemsTheSame(oldItem: MovieResponse.Movie, newItem: MovieResponse.Movie): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: MovieResponse.Movie, newItem: MovieResponse.Movie): Boolean = oldItem == newItem
    }
}
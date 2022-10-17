package com.example.popularMoviesGuide.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.popularMoviesGuide.R
import com.example.popularMoviesGuide.data.entity.Result
import com.squareup.picasso.Picasso

class CustomAdapter(
    private val moviesList: List<Result?>,
    val mItemClickListener: ItemClickListener
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(itemId: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val path = "https://image.tmdb.org/t/p/w500/" + moviesList[position]?.poster_path
        Picasso.get().load(path).into(holder.imageView)
        holder.moviePreviewTitle.text = moviesList[position]?.title
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.movie_preview_imageview)
        val moviePreviewTitle: TextView = itemView.findViewById(R.id.movie_preview_title)

        init {
            itemView.setOnClickListener {
                moviesList[bindingAdapterPosition]?.id?.let(mItemClickListener::onItemClick)
            }
        }
    }
}
package com.practice.moviz.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.moviz.R
import com.practice.moviz.data.model.Story

class HomeStoryAdapter(
    val stories: List<Story>
) : RecyclerView.Adapter<HomeStoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = stories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stories[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.item_story_txt_title)
        private val image: ImageView = view.findViewById(R.id.item_story_img_background)

        fun bind(story: Story) {
            title.setText(story.title)

            Glide
                .with(itemView.context)
                .load(story.icon)
                .circleCrop()
                .into(image)

            itemView.setOnClickListener{
                val action = HomeFragmentDirections.actionHomeFragmentToStoryFragment()
                it.findNavController().navigate(action)
            }
        }
    }
}
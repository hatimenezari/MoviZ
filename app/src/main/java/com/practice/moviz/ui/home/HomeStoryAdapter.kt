package com.practice.moviz.ui.home

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.moviz.R
import com.practice.moviz.data.model.Story
import com.practice.moviz.databinding.ItemStoryBinding

class HomeStoryAdapter(
    val stories: List<Story>
) : RecyclerView.Adapter<HomeStoryAdapter.StoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view: ItemStoryBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_story,
            parent,
            false
        )
        return StoryViewHolder(view)
    }

    override fun getItemCount(): Int = stories.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.view.story = stories[position]
    }

    inner class StoryViewHolder(var view: ItemStoryBinding) : RecyclerView.ViewHolder(view.root)
}
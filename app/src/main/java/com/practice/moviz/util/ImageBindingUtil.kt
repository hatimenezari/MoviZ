package com.practice.moviz.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class ImageBindingUtil {
    companion object {
        @JvmStatic
        @BindingAdapter("image")
        fun loadImage(view: ImageView, icon: Int) {
            Glide
                .with(view.context)
                .load(icon)
                .circleCrop()
                .into(view)
        }
    }
}
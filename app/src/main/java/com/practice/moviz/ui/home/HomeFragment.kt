package com.practice.moviz.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.practice.moviz.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {


    private val viewModel: HomeViewModel by navGraphViewModels(R.id.nav_graph){
        defaultViewModelProviderFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        home_rclv_stories.adapter = HomeStoryAdapter(viewModel.storiesList())
    }

}
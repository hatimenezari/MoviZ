package com.practice.moviz.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.navGraphViewModels
import com.practice.moviz.R
import com.practice.moviz.data.model.Story
import com.practice.moviz.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by navGraphViewModels(R.id.nav_graph){
        defaultViewModelProviderFactory
    }

    @Inject
    lateinit var defaultStory: Story

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: HomeFragmentBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.home_fragment,
            container,
            false
        )
        binding.storyAdapter = HomeStoryAdapter(viewModel.storiesList())
        binding.defaultStory = defaultStory
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

}
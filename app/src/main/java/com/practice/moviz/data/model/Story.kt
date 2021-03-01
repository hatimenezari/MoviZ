package com.practice.moviz.data.model

import com.practice.moviz.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

data class Story constructor(
    val icon: Int = R.drawable.ic_launcher_background,
    val title: String = "Votre Story",
    val defaultStory: Boolean = false
)

@Module
@InstallIn(ActivityComponent::class)
object StoryModule {
    @Provides
    fun provideDefaultStory() =  Story()

}

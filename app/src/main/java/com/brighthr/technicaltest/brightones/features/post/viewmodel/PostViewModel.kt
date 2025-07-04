package com.brighthr.technicaltest.brightones.features.post.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brighthr.technicaltest.brightones.features.post.model.Post
import com.brighthr.technicaltest.brightones.features.post.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/*
* Updated PostViewModel to be Injected by DaggerHilt.
* Switched to StateFlow to load and view Posts
* Improved encapsulation by making Mutable private while exposing StateFlow.
* */

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    fun loadPost() {
        viewModelScope.launch {
            val result = postRepository.retrieveAllPosts()
            _posts.value = (result.shuffled())
        }
    }

    // TODO : Navigation to be implemented.
    fun navigateToDetails() {
    }
}
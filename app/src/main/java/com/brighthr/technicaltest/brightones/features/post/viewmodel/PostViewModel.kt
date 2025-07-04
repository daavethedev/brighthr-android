package com.brighthr.technicaltest.brightones.features.post.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brighthr.technicaltest.brightones.features.post.model.Post
import com.brighthr.technicaltest.brightones.network.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/*
* MAJOR CHANGES on the ViewModel
* Updated PostViewModel to be Injected by DaggerHilt.
* Switched to StateFlow to load and view Posts
* Improved encapsulation by making Mutable private while exposing StateFlow.
*
* Navigation Added to the ViewModel to help cleaner architecture.
*
*
* */

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    private val _navigateToDetails = MutableStateFlow(0)
    val navigateToDetails: StateFlow<Int> = _navigateToDetails

    private val _postDetails: MutableStateFlow<Post> = MutableStateFlow<Post>(Post())
    val postDetails = _postDetails

    fun loadPosts() {
        viewModelScope.launch {
            val result = postRepository.retrieveAllPosts()
            _posts.value = (result.shuffled())
        }
    }

    fun loadPostById(id: Int) {
        viewModelScope.launch {
            val result = postRepository.retrievePostWithId(postId = id)
            _postDetails.value = result
        }
    }

    fun navigateToDetails(postId: Int) {
        viewModelScope.launch {
            _navigateToDetails.emit(postId)
        }
    }

    fun onNavigated() {
        viewModelScope.launch {
            _navigateToDetails.emit(0)
        }
    }
}
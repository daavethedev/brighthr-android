package com.brighthr.technicaltest.brightones.network.repository

import com.brighthr.technicaltest.brightones.features.post.model.Post
import javax.inject.Inject

/*
*
* Injection for PostService was added.
*
* */


open class PostRepository @Inject constructor(
    private val postService: PostService
) {

    suspend fun retrieveAllPosts(): List<Post> {
        return postService.retrieveAllPosts()
    }

    suspend fun retrievePostWithId(postId: Int): Post {
        return postService.retrievePostWithId(postId = postId)
    }
}
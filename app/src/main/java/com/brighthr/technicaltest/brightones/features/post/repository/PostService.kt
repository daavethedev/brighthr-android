package com.brighthr.technicaltest.brightones.features.post.repository

import com.brighthr.technicaltest.brightones.features.post.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {
    @GET("posts")
    suspend fun retrieveAllPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun retrievePostWithId(
        @Path("id") postId: Int
    ): Post
}
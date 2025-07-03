package com.brighthr.technicaltest.brightones.features.post.repository

import com.brighthr.technicaltest.brightones.features.post.model.Post
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostRepository {

    private val builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder()
                    .create()
            )
        )

    private var retrofit = builder.build()

    suspend fun retrieveAllPosts(): List<Post> {
        return retrofit.create(PostService::class.java).retrieveAllPosts()
    }

}
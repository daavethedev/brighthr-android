package com.brighthr.technicaltest.brightones.network

import com.brighthr.technicaltest.brightones.features.post.info.Constants
import com.brighthr.technicaltest.brightones.network.repository.PostService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
*
* Added Network Module to provide Retrofit instances as it was being created for each and
* every network call. This consumes less memory and make the App light weight.
*
* */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.Companion.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
    }

    @Provides
    @Singleton
    fun providesPostService(retrofit: Retrofit): PostService {
        return retrofit.create(PostService::class.java)
    }
}
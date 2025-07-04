package com.brighthr.technicaltest.brightones.features.post.ui.postlist

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.brighthr.technicaltest.brightones.features.post.ui.postlist.component.PostListView
import com.brighthr.technicaltest.brightones.features.post.viewmodel.PostViewModel


/*
*
* PostListScreen renamed and broken down into smaller components to make testing and readability
* better. Also added DaggerHilt for the ViewModel to be Injected it was being instantiated which is
* not a good approach.
*
* */

@Composable
fun PostScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: PostViewModel = hiltViewModel(),
) {
    val posts by viewModel.posts.collectAsState()
    val postToNavigateTo by viewModel.navigateToDetails.collectAsState()

    LaunchedEffect(Unit) {
        Log.i("mytag", "Loading posts...")
        viewModel.loadPosts()
    }

    LaunchedEffect(postToNavigateTo) {
        if (postToNavigateTo != 0) {
            navController.navigate("PostDetails/$postToNavigateTo")
            viewModel.onNavigated()
        }
    }

    PostListView(
        modifier = modifier, posts = posts, onPostClick = { clickedPostId ->
            viewModel.navigateToDetails(clickedPostId)
        })
}
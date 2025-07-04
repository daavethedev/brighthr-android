package com.brighthr.technicaltest.brightones.features.post.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.brighthr.technicaltest.brightones.features.post.ui.screen.component.PostListView
import com.brighthr.technicaltest.brightones.features.post.viewmodel.PostViewModel

@Composable
fun PostScreen(
    modifier: Modifier = Modifier,
    viewModel: PostViewModel = hiltViewModel(),
) {

    val posts by viewModel.posts.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadPost()
    }

    PostListView(
        modifier = modifier, posts = posts, onPostClick = { viewModel.navigateToDetails() })
}
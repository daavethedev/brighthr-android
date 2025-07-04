package com.brighthr.technicaltest.brightones.features.post.ui.postlist.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brighthr.technicaltest.brightones.features.post.model.Post
import com.brighthr.technicaltest.brightones.features.post.ui.postlist.reusable.PostItemView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostListView(modifier: Modifier = Modifier, posts: List<Post>, onPostClick: (Int) -> Unit) {
    Scaffold(
        modifier = modifier, topBar = {
            TopAppBar(title = { Text(text = "Posts") })
        }) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(posts.size) { i  ->
                PostItemView(post = posts[i], onPostClick = onPostClick)
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}
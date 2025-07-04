package com.brighthr.technicaltest.brightones.features.post.ui.postdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.brighthr.technicaltest.brightones.features.post.viewmodel.PostViewModel

/*
*
* Created PostDetailsScreen to show the user the complete contents of a post, pretty basic with
* a header and the post body.
*
* */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostDetailsScreen(
    modifier: Modifier = Modifier, postId: Int, viewModel: PostViewModel = hiltViewModel()
) {
    val postDetails by viewModel.postDetails.collectAsState()

    LaunchedEffect(postDetails) {
        viewModel.loadPostById(id = postId)
    }

    Scaffold(
        modifier = modifier, topBar = {
            TopAppBar(title = { Text(text = postDetails.title) })
        }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = postDetails.title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
            postDetails.body?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
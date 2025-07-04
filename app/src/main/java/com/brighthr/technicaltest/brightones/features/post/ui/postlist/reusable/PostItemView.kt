package com.brighthr.technicaltest.brightones.features.post.ui.postlist.reusable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brighthr.technicaltest.brightones.features.post.model.Post

@Composable
fun PostItemView(
    post: Post,
    onPostClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .clickable { onPostClick() }
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = post.title,
            style = MaterialTheme.typography.titleSmall
        )
        post.body?.let { myText ->
            Text(text = myText)
        }
    }
}
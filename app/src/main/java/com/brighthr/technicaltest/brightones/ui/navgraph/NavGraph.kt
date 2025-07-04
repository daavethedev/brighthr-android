package com.brighthr.technicaltest.brightones.ui.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.brighthr.technicaltest.brightones.features.post.ui.postdetails.PostDetailsScreen
import com.brighthr.technicaltest.brightones.features.post.ui.postlist.PostScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = "PostList"
    ) {
        composable(route = "PostList") {
            PostScreen(modifier = Modifier.fillMaxSize(), navController = navController)
        }

        composable(route = "PostDetails/{postId}") { navBackStackEntry ->
            val postId = navBackStackEntry.arguments?.getString("postId")?.toIntOrNull() ?: 0
            PostDetailsScreen(modifier = Modifier.fillMaxSize(), postId = postId)
        }
    }
}

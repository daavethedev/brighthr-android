package com.brighthr.technicaltest.brightones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brighthr.technicaltest.brightones.ui.navgraph.NavGraph
import com.brighthr.technicaltest.brightones.features.post.ui.postlist.PostScreen
import com.brighthr.technicaltest.brightones.ui.theme.BrightonesTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Please carefully read the README, in the root project directory,
 * in order to complete this tech task.
 */


/**
 * Updated the Navigation to add a NavGraph, which is maintained in a separate file.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrightonesTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }


    // removed MainNavigation fun, moved it to a separate file.
    // Doing so make it easier to maintain your routes.
}
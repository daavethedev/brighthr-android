package com.brighthr.technicaltest.brightones

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.brighthr.technicaltest.brightones.features.post.model.Post
import com.brighthr.technicaltest.brightones.features.post.ui.postlist.component.PostListView
import com.brighthr.technicaltest.brightones.features.post.ui.postlist.reusable.PostItemView
import org.junit.Rule
import org.junit.Test

class PostListViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun postListView_displaysPostsAndHandlesClick() {
        val mockPosts = listOf(
            Post(
                id = 1,
                title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                userId = 1
            ),
            Post(id = 2, title = "qui est esse", userId = 1),
        )

        var clickedPostId: Int? = null

        composeTestRule.setContent {
            PostListView(
                posts = mockPosts, onPostClick = { clickedPostId = it })
        }

        composeTestRule.onNodeWithText("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
            .assertIsDisplayed()
        composeTestRule.onNodeWithText("qui est esse").assertIsDisplayed()

        composeTestRule.onNodeWithText("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
            .performClick()

        assert(clickedPostId == 1)
    }

    @Test
    fun postItemView_displaysTitleAndBodyAndHandlesClick() {
        val post = Post(
            id = 42,
            title = "ea molestias quasi exercitationem repellat qui ipsa sit aut",
            userId = 1
        )

        var clickedPostId: Int? = null

        composeTestRule.setContent {
            PostItemView(post = post, onPostClick = { clickedPostId = it })
        }

        composeTestRule.onNodeWithText("ea molestias quasi exercitationem repellat qui ipsa sit aut")
            .assertIsDisplayed()
        composeTestRule.onNodeWithText("et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut")
            .assertIsDisplayed()

        composeTestRule.onNodeWithText("ea molestias quasi exercitationem repellat qui ipsa sit aut")
            .performClick()
        assert(3 == clickedPostId)
    }
}
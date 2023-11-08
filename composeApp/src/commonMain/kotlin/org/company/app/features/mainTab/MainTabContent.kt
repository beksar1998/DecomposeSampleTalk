package org.company.app.features.mainTab

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import org.company.app.features.mainTab.home.HomeTabContent
import org.company.app.features.mainTab.profile.ProfileContent


@OptIn(ExperimentalDecomposeApi::class, ExperimentalFoundationApi::class)
@Composable
fun MainTabContent(component: MainTabComponent) {
    val pages by component.pages.subscribeAsState()
    val currentPageIndex = pages.selectedIndex
    val pagerState = rememberPagerState { 0 }

    LaunchedEffect(currentPageIndex) {
        pagerState.scrollToPage(currentPageIndex)
    }

    Column {
        Box(modifier = Modifier.weight(1F)) {

            when (val page = pages.items[pages.selectedIndex].instance) {
                is MainTabComponent.MainTabs.HomeTab -> {
                    HomeTabContent(page.component)
                }

                is MainTabComponent.MainTabs.ProfileTab -> {
                    ProfileContent(page.component)
                }

                else -> {}
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                component.changeTab(0)
            }) {
                Text("Home")
            }

            Button(onClick = {
                component.changeTab(1)
            }) {
                Text("Profile")
            }
        }
    }
}
package org.company.app.features.mainTab

import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.value.Value
import org.company.app.features.mainTab.home.HomeTabComponent
import org.company.app.features.mainTab.profile.ProfileComponent

interface MainTabComponent {

    fun changeTab(index: Int)

    @OptIn(ExperimentalDecomposeApi::class)
    val pages: Value<ChildPages<*, MainTabs>>
    val configs: List<MainTabNavigation>

    sealed interface MainTabs {

        class HomeTab(val component: HomeTabComponent) : MainTabs
        class ProfileTab(val component: ProfileComponent) : MainTabs


    }
}
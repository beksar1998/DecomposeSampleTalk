@file:OptIn(ExperimentalDecomposeApi::class)

package org.company.app.features.mainTab

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.company.app.features.mainTab.home.DefaultHomeTabComponent
import org.company.app.features.mainTab.home.HomeTabComponent
import org.company.app.features.mainTab.profile.DefaultProfileComponent
import org.company.app.features.mainTab.profile.ProfileComponent
import org.company.app.features.root.RootNavigation

@OptIn(ExperimentalDecomposeApi::class)
class DefaultMainTabComponent(
    componentContext: ComponentContext,
    private val rootNavigation: StackNavigation<RootNavigation>
) : MainTabComponent,
    ComponentContext by componentContext {

    override val configs: List<MainTabNavigation> =
        listOf(MainTabNavigation.Home, MainTabNavigation.Profile)


    override val pages: Value<ChildPages<*, MainTabComponent.MainTabs>>
        get() = _pages


    private val navigation = PagesNavigation<MainTabNavigation>()

    private val _pages = this.childPages(
        source = navigation,
        initialPages = {
            Pages(
                items = configs,
                selectedIndex = 0,
            )
        },
        childFactory = ::createChildPageFactor
    )

    private val mainDispatcher = CoroutineScope(Dispatchers.Main)
    override fun changeTab(index: Int) {
        mainDispatcher.launch {
            navigation.select(index)
        }
    }

    private fun createChildPageFactor(
        tabs: MainTabNavigation,
        componentContext: ComponentContext,
    ): MainTabComponent.MainTabs {
        return when (tabs) {
            MainTabNavigation.Home -> MainTabComponent.MainTabs.HomeTab(
                homeTabComponent(
                    componentContext
                )
            )

            MainTabNavigation.Profile -> MainTabComponent.MainTabs.ProfileTab(
                profileTabComponent(
                    componentContext
                )
            )
        }
    }


    private fun homeTabComponent(
        componentContext: ComponentContext,
    ): HomeTabComponent {
        return DefaultHomeTabComponent(componentContext, rootNavigation)
    }

    private fun profileTabComponent(componentContext: ComponentContext): ProfileComponent {
        return DefaultProfileComponent(componentContext)
    }


}
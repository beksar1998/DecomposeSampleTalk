package org.company.app.features.mainTab.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import org.company.app.features.root.RootNavigation
import org.company.app.features.temp.DefaultTempComponent
import org.company.app.features.temp.TempComponent

class DefaultHomeTabComponent(
    componentContext: ComponentContext,
    private val rootNavigation: StackNavigation<RootNavigation>
) : HomeTabComponent,
    ComponentContext by componentContext {


    override val navigation = StackNavigation<HomeTabNavigation>()

    override val stack: Value<ChildStack<*, HomeTabComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = HomeTabNavigation.Home,
        handleBackButton = true,
        childFactory = ::child,
    )


    private fun child(
        config: HomeTabNavigation,
        childComponentContext: ComponentContext
    ): HomeTabComponent.Child {
        return when (config) {
            is HomeTabNavigation.Temp -> HomeTabComponent.Child.Temp(
                tempComponent(
                    config.title,
                    childComponentContext
                )
            )

            HomeTabNavigation.Home -> HomeTabComponent.Child.Temp(
                homeComponent(
                    childComponentContext
                )
            )
        }
    }

    private fun tempComponent(title: Int, context: ComponentContext): TempComponent {
        return DefaultTempComponent(title, context, navigation, rootNavigation)
    }

    private fun homeComponent(context: ComponentContext): TempComponent {
        return DefaultTempComponent(1, context, navigation,rootNavigation)
    }


}
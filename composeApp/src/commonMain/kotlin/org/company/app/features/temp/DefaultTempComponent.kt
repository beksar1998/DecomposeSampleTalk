package org.company.app.features.temp

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.replaceAll
import org.company.app.features.mainTab.home.HomeTabNavigation
import org.company.app.features.root.RootNavigation

class DefaultTempComponent(
    override val title: Int,
    componentContext: ComponentContext,
    override val navigation: StackNavigation<HomeTabNavigation>,
    override val rootNavigation: StackNavigation<RootNavigation>
) : TempComponent,
    ComponentContext by componentContext {


    override fun navToLogin() {
        rootNavigation.replaceAll(RootNavigation.Login)
    }

}
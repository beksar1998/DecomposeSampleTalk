package org.company.app.features.login

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.replaceAll
import org.company.app.features.root.RootNavigation

class DefaultLoginComponent(
    componentContext: ComponentContext,
    private val navigation: StackNavigation<RootNavigation>
) : LoginComponent,
    ComponentContext by componentContext {

    override fun navToMainTab() {
        navigation.replaceAll(RootNavigation.MainTab)
    }
}
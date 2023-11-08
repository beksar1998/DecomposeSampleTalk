package org.company.app.features.onBoarding

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.replaceAll
import org.company.app.features.root.RootNavigation

class DefaultOnBoardingComponent(
    componentContext: ComponentContext,
    private val navigation: StackNavigation<RootNavigation>
) : OnBoardingComponent,
    ComponentContext by componentContext {
    override fun navToLogin() {
        navigation.replaceAll(RootNavigation.Login)
    }
}
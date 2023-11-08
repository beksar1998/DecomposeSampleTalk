package org.company.app.features.splash

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import org.company.app.features.root.RootNavigation

class DefaultSplashComponent(
    componentContext: ComponentContext,
    private val navigation: StackNavigation<RootNavigation>,
) : SplashComponent, ComponentContext by componentContext {


    override fun navToOnBoarding() {
        navigation.replaceAll(RootNavigation.OnBoarding)
    }
}
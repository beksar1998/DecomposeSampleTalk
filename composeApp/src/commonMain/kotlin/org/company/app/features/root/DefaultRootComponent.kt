package org.company.app.features.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import org.company.app.features.login.DefaultLoginComponent
import org.company.app.features.login.LoginComponent
import org.company.app.features.mainTab.DefaultMainTabComponent
import org.company.app.features.mainTab.MainTabComponent
import org.company.app.features.onBoarding.DefaultOnBoardingComponent
import org.company.app.features.onBoarding.OnBoardingComponent
import org.company.app.features.splash.DefaultSplashComponent
import org.company.app.features.splash.SplashComponent

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    override val rootNavigation = StackNavigation<RootNavigation>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = rootNavigation,
            initialConfiguration = RootNavigation.Splash,
            handleBackButton = true,
            childFactory = ::child,
        )


    private fun child(
        config: RootNavigation,
        childComponentContext: ComponentContext
    ): RootComponent.Child =
        when (config) {
            RootNavigation.Splash -> RootComponent.Child.Splash(
                splashComponent(
                    childComponentContext
                )
            )

            RootNavigation.OnBoarding -> RootComponent.Child.OnBoarding(
                onBoardingComponent(
                    childComponentContext
                )
            )

            RootNavigation.Login -> RootComponent.Child.Login(
                loginComponent(
                    childComponentContext
                )
            )

            RootNavigation.MainTab -> RootComponent.Child.MainTab(
                mainTabComponent(
                    childComponentContext
                )
            )
        }

    private fun splashComponent(componentContext: ComponentContext): SplashComponent {
        return DefaultSplashComponent(componentContext, rootNavigation)
    }

    private fun mainTabComponent(componentContext: ComponentContext): MainTabComponent {
        return DefaultMainTabComponent(componentContext,rootNavigation)
    }

    private fun loginComponent(componentContext: ComponentContext): LoginComponent {
        return DefaultLoginComponent(componentContext, rootNavigation)
    }

    private fun onBoardingComponent(componentContext: ComponentContext): OnBoardingComponent {
        return DefaultOnBoardingComponent(componentContext, rootNavigation)
    }


}
package org.company.app.features.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value
import org.company.app.features.login.LoginComponent
import org.company.app.features.mainTab.MainTabComponent
import org.company.app.features.onBoarding.OnBoardingComponent
import org.company.app.features.splash.SplashComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    val rootNavigation: StackNavigation<RootNavigation>

    sealed interface Child {

        class Splash(val component: SplashComponent) : Child
        class OnBoarding(val component: OnBoardingComponent) : Child
        class Login(val component: LoginComponent) : Child
        class MainTab(val component: MainTabComponent) : Child

    }

}
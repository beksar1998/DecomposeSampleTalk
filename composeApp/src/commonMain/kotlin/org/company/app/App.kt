package org.company.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import org.company.app.features.login.LoginContent
import org.company.app.features.mainTab.MainTabContent
import org.company.app.features.onBoarding.OnBoardingContent
import org.company.app.features.root.RootComponent
import org.company.app.features.splash.SplashContent

@Composable
internal fun Root(component: RootComponent) {
    Column(modifier = Modifier.fillMaxSize()) {
        Children(
            stack = component.stack,
            modifier = Modifier.fillMaxSize(),
        ) {
            when (val instance = it.instance) {
                is RootComponent.Child.Splash -> SplashContent(component = instance.component)
                is RootComponent.Child.OnBoarding -> OnBoardingContent(component = instance.component)
                is RootComponent.Child.Login -> LoginContent(component = instance.component)
                is RootComponent.Child.MainTab -> MainTabContent(component = instance.component)
            }
        }
    }
}


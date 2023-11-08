package org.company.app.features.splash

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay


@Composable
fun SplashContent(component: SplashComponent) {
    Text("SPLASH")
    LaunchedEffect(Unit){
        delay(1000)
        component.navToOnBoarding()
    }
}
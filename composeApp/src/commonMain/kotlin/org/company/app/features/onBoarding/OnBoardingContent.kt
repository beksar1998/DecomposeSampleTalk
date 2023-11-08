package org.company.app.features.onBoarding

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun OnBoardingContent(component: OnBoardingComponent) {
    Column {
        Text("OnBoardingContent")

        Button(onClick = {
            component.navToLogin()
        }) {
            Text("Login")
        }
    }
}
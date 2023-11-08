package org.company.app.features.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.company.app.features.root.RootComponent


@Composable
fun LoginContent(component: LoginComponent) {
    Column {
        Text("Login")

        Button(onClick = {
            component.navToMainTab()
        }) {
            Text("Main")
        }
    }
}
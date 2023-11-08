package org.company.app.features.temp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.popWhile
import com.arkivanov.decompose.router.stack.push
import org.company.app.features.mainTab.home.HomeTabNavigation

@Composable
fun TempContent(component: TempComponent) {


    Column {
        Text(component.title.toString())
        Button(onClick = {
            component.navigation.pop()
        }) {
            Text("Back")

        }
        Button(onClick = {
            component.navigation.popTo(0)
        }) {
            Text("Home(Root)")

        }

        Button(onClick = {
            component.navigation.push(HomeTabNavigation.Temp(component.title + 1))
        }) {
            Text("Next")
        }

        Button(onClick = {
            component.navToLogin()
        }) {
            Text("Login")
        }
    }
}
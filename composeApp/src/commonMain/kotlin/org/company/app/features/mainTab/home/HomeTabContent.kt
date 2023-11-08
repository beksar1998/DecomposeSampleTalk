package org.company.app.features.mainTab.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import org.company.app.features.temp.TempContent


@Composable
fun HomeTabContent(component: HomeTabComponent) {
    Column(modifier = Modifier.fillMaxSize()) {
        Children(
            stack = component.stack,
            modifier = Modifier.fillMaxSize(),
        ) {
            when (val instance = it.instance) {
                is HomeTabComponent.Child.Temp -> TempContent(instance.component)
            }
        }
    }
}
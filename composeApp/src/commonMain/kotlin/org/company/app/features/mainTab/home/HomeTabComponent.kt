package org.company.app.features.mainTab.home

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.value.Value
import org.company.app.features.temp.TempComponent

interface HomeTabComponent {

    val stack: Value<ChildStack<*, Child>>

    val navigation: StackNavigation<HomeTabNavigation>


    sealed interface Child {

        class Temp(val component: TempComponent) : Child
    }
}
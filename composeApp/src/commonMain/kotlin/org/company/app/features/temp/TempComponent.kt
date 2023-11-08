package org.company.app.features.temp

import com.arkivanov.decompose.router.stack.StackNavigation
import org.company.app.features.mainTab.home.HomeTabNavigation
import org.company.app.features.root.RootNavigation

interface TempComponent {


    val title: Int

    val navigation: StackNavigation<HomeTabNavigation>
    val rootNavigation: StackNavigation<RootNavigation>

    fun navToLogin()
}
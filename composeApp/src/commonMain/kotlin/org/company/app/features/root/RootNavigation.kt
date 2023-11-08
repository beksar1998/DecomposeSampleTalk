package org.company.app.features.root

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

sealed class RootNavigation : Parcelable {

    @Parcelize
    object Splash : RootNavigation()

    @Parcelize
    object OnBoarding : RootNavigation()

    @Parcelize
    object Login : RootNavigation()

    @Parcelize
    object MainTab : RootNavigation()

}
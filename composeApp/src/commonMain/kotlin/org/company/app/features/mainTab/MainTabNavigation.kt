package org.company.app.features.mainTab

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

sealed interface MainTabNavigation : Parcelable {


    @Parcelize
    object Home : MainTabNavigation

    @Parcelize
    object Profile : MainTabNavigation


}
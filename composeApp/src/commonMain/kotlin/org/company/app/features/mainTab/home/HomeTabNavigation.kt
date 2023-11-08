package org.company.app.features.mainTab.home

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

sealed interface HomeTabNavigation : Parcelable {


    @Parcelize
    object Home : HomeTabNavigation

    @Parcelize
    data class Temp(val title: Int) : HomeTabNavigation
}
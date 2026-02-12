package com.gmail.denuelle42.denuboilerplate.navigation

sealed class NavBehavior {
    object None : NavBehavior()
    object ClearAll : NavBehavior()
    data class PopUpTo(
        val destination: NavigationScreens? = null,
        val intId: Int? = 0,
        val inclusive: Boolean = true
    ) : NavBehavior()
}

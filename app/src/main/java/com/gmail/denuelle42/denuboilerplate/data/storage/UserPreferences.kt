package com.gmail.denuelle42.denuboilerplate.data.storage

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    val token : String? = null
)


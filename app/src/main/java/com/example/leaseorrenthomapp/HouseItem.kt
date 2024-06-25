package com.example.leaseorrenthomapp

import java.io.Serializable

data class HouseItem (
    val imageResId: Int,
    val address: String,
    val price: String
):Serializable
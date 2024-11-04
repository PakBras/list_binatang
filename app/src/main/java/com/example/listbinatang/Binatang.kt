package com.example.listbinatang

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Binatang(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
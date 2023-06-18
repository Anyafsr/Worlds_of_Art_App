package com.example.worldsofart

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Museum (
    val imgmuseum: Int,
    val namemuseum: String,
    val descmuseum: String,
    val url: String
) : Parcelable
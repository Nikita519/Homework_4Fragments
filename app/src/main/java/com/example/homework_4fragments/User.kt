package com.example.homework_4fragments

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val photo: String,
    val name: String,
    val lastname: String,
    val phone: String
): Parcelable
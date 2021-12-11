package com.example.gadsag19educationquiz.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Subjects(val image: Int, val subject: String) : Parcelable {
}

package com.sowroom.app.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val arti: String ="",
    val asma: String ="",
    val audio: String="",
    val ayat: String="",
    val keterangan: String="",
    val nama: String="",
    val nomor: String="",
    val rukuk: String="",
    val type: String="",
    val urut: String=""
) : Parcelable

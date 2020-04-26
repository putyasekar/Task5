package com.diki.idn.task5

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model(
    var title: String,
    var desc: String,
    var date: String,
    var place: String,
    var type: String,
    var image: Int
) : Parcelable
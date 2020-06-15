package com.example.mycabaca.data.source.remote.response.genre

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenreResponse(
	val resource: List<Genre>
) : Parcelable

@Parcelize
data class Genre(
	val iconUrl: String? = null,
	val count: Int? = null,
	val id: Int? = null,
	val title: String? = null
) : Parcelable

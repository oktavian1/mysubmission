package com.example.mycabaca.data.source.remote.response.book

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookResponse(

	@field:SerializedName("result")
	val result: List<ResultItem>,

	@field:SerializedName("test")
	val test: Test? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
) : Parcelable

@Parcelize
data class WriterByWriterId(

	@field:SerializedName("user_id")
	val userId: Int? = null,



	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("schedule_task")
	val scheduleTask: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("User_by_user_id")
	val userByUserId: UserByUserId? = null,


	@field:SerializedName("royalty_id")
	val royaltyId: Int? = null
) : Parcelable

@Parcelize
data class Test(

	@field:SerializedName("id")
	val id: Int? = null
) : Parcelable

@Parcelize
data class GenreByGenreId(

	@field:SerializedName("icon_url")
	val iconUrl: String? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
) : Parcelable

@Parcelize
data class UserByUserId(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
) : Parcelable

@Parcelize
data class ResultItem(

	@field:SerializedName("Writer_by_writer_id")
	val writerByWriterId: WriterByWriterId? = null,

	@field:SerializedName("cover_url")
	val coverUrl: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("isNew")
	val isNew: Boolean? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("schedule_task")
	val scheduleTask: String? = null,

	@field:SerializedName("genre_id")
	val genreId: Int? = null,

	@field:SerializedName("Genre_by_genre_id")
	val genreByGenreId: GenreByGenreId? = null,

	@field:SerializedName("is_update")
	val isUpdate: Boolean? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("rate_sum")
	val rateSum: Double? = null,

	@field:SerializedName("writer_id")
	val writerId: Int? = null,

	@field:SerializedName("view_count")
	val viewCount: Int? = null,

	@field:SerializedName("chapter_count")
	val chapterCount: Int? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("book_url")
	val bookUrl: String? = null
) : Parcelable

package com.example.mycabaca.data.source.remote.response.book

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailResponse(
	val result: Result,
	val success: Boolean? = null
) : Parcelable

@Parcelize
data class GenresItem(
	val iconUrl: String? = null,
	val isPrimary: Int? = null,
	val count: Int? = null,
	val id: Int? = null,
	val title: String? = null
) : Parcelable

@Parcelize
data class WriterByWriterIds(
	val userId: Int? = null,
	val id: Int? = null,
	val userByUserId: UserByUserIds
) : Parcelable

@Parcelize
data class RelatedByBookItem(
	val coverUrl: String? = null,
	val id: Int? = null,
	val title: String? = null
) : Parcelable

@Parcelize
data class BookChapterByBookIdItem(
	val jsonMemberNew: Boolean? = null,
	val likeCount: Int? = null,
	val isReaded: Boolean? = null,
	val createdAt: String? = null,
	val bookId: Int? = null,
	val title: String? = null,
	val scheduleTask: String? = null,
	val viewByUser: Int? = null,
	val price: Int? = null,
	val chapterSequence: Int? = null,
	val id: Int? = null,
	val viewCount: Int? = null,
	val isPurchased: Boolean? = null
) : Parcelable

@Parcelize
data class Result(
	val writerByWriterId: WriterByWriterIds?,
	val isContractActived: Boolean? = null,
	val createdAt: String? = null,
	val voted: Boolean? = null,
	val bookChapterByBookId: List<BookChapterByBookIdItem?>? = null,
	val urlLanding: String? = null,
	val title: String? = null,
	val download: Int? = null,
	val updatedAt: String? = null,
	val reviews: List<ReviewsItem>,
	val happyhour: Boolean? = null,
	val genres: List<GenresItem?>? = null,
	val isUpdate: Boolean? = null,
	val relatedByBook: List<RelatedByBookItem?>? = null,
	val bookUrl: String? = null,
	val id: Int? = null,
	val fullPurchase: Boolean? = null,
	val writerId: Int? = null,
	val voteCount: String? = null,
	val autoBuyChapter: Boolean? = null,
	val userReview: String? = null,
	val chapterCount: Int? = null,
	val decimalRate: Double? = null,
	val coverUrl: String? = null,
	val averageRate: Int? = null,
	val synopsis: String? = null,
	val isNew: Boolean? = null,
	val scheduleTask: String? = null,
	val timeToVote: Boolean? = null,
	val fullPurchased: Boolean? = null,
	val chapterPaidCount: Int? = null,
	val daily: String? = null,
	val isFree: Boolean? = null,
	val fullPrice: Int? = null,
	val viewCount: Int? = null,
	val status: String? = null,
	val desc: String? = null
) : Parcelable

@Parcelize
data class ReviewsItem(
	val updatedAt: String? = null,
	val userId: Int? = null,
	val userByReviewerId: UserByReviewerId? = null,
	val review: String? = null,
	val rating: Int? = null,
	val id: Int? = null
) : Parcelable


@Parcelize
data class UserByReviewerId(
	val name: String? = null,
	val id: Int? = null,
	val photoUrl: String? = null,
	val email: String? = null,
	val username: String? = null
) : Parcelable

@Parcelize
data class UserByUserIds(
	val name: String? = null,
	val id: Int? = null,
	val photoUrl: String,
	val username: String? = null
) : Parcelable

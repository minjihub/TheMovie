package com.example.themovie.model

import android.os.Parcel
import android.os.Parcelable

data class MovieDetail(val vote_count:Int,
                       val vote_average: Float,
                       val title: String?,
                       val release_date: String?,
                       val poster_path: String?,
                       val overview: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readFloat(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(vote_count)
        parcel.writeFloat(vote_average)
        parcel.writeString(title)
        parcel.writeString(release_date)
        parcel.writeString(poster_path)
        parcel.writeString(overview)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieDetail> {
        override fun createFromParcel(parcel: Parcel): MovieDetail {
            return MovieDetail(parcel)
        }

        override fun newArray(size: Int): Array<MovieDetail?> {
            return arrayOfNulls(size)
        }
    }

}
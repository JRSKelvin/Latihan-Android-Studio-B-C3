package com.binaracademy.binarandroidchapter3.data

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Mahasiswa(val nama: String, val email: String, val univ: String) : Serializable

data class Mahasiswa2(val nama: String?, val email: String?, val univ: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeString(email)
        parcel.writeString(univ)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mahasiswa2> {
        override fun createFromParcel(parcel: Parcel): Mahasiswa2 {
            return Mahasiswa2(parcel)
        }

        override fun newArray(size: Int): Array<Mahasiswa2?> {
            return arrayOfNulls(size)
        }
    }
}
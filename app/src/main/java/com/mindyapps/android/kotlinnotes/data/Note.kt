package com.mindyapps.android.kotlinnotes.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "note_table")
data class Note(var title: String, var text: String, @PrimaryKey (autoGenerate = true) var id: Int?): Parcelable{
    constructor():this("","",-1)
}
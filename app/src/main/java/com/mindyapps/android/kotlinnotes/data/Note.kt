package com.mindyapps.android.kotlinnotes.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "note_table")
data class Note(val title: String, val text: String): Parcelable{ @PrimaryKey (autoGenerate = true) var id: Int = 0 }
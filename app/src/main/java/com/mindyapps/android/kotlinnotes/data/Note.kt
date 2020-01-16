package com.mindyapps.android.kotlinnotes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(@PrimaryKey (autoGenerate = true) val id: Int? = null, val title: String, val text: String)
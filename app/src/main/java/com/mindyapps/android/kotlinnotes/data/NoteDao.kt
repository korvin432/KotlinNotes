package com.mindyapps.android.kotlinnotes.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao{

    @Query("SELECT * from note_table ORDER BY id ASC")
    fun getNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Query("DELETE FROM note_table")
    suspend fun deleteAll()

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

}
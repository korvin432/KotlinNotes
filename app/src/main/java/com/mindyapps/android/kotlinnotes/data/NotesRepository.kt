package com.mindyapps.android.kotlinnotes.data

import androidx.lifecycle.LiveData

class NotesRepository(private val noteDao: NoteDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allNotes: LiveData<List<Note>> = noteDao.getNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }
}
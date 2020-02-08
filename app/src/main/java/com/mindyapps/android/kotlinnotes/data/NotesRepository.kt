package com.mindyapps.android.kotlinnotes.data

import android.util.Log
import androidx.lifecycle.LiveData

class NotesRepository(private val noteDao: NoteDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allNotes: LiveData<List<Note>> = noteDao.getNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    suspend fun update(note: Note) {
        Log.d("qwwe", "updating $note.id")
        noteDao.update(note)
    }
}
package com.mindyapps.android.kotlinnotes.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mindyapps.android.kotlinnotes.data.Note
import com.mindyapps.android.kotlinnotes.data.NoteDatabase
import com.mindyapps.android.kotlinnotes.data.NotesRepository
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: NotesRepository
    // LiveData gives us updated words when they change.
    val allNotes: LiveData<List<Note>>

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val notesDao = NoteDatabase.getDatabase(application, viewModelScope).noteDao()
        repository = NotesRepository(notesDao)
        allNotes = repository.allNotes
    }

    fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
        Log.d("qwwe", "inserting")
    }
}
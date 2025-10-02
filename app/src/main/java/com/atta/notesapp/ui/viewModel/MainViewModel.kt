package com.atta.notesapp.ui.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atta.notesapp.data.model.Note
import com.atta.notesapp.data.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(private val repo: NotesRepository) : ViewModel() {



    fun insertNote(note: Note) {
        viewModelScope.launch {
            repo.insert(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            repo.update(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repo.delete(note)
        }
    }

    fun getNotes():Flow<List<Note>>{
        return repo.getNotes()
    }





}

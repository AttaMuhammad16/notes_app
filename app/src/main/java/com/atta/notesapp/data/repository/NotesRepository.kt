package com.atta.notesapp.data.repository

import android.content.Context
import com.atta.notesapp.data.local.AppDataBase
import com.atta.notesapp.data.model.Note
import kotlinx.coroutines.flow.Flow

class NotesRepository(private var context:Context) {

    private val db= AppDataBase.getInstance(context)

    suspend fun insert(note: Note)=db.notesDao().insert(note)
    suspend fun update(note: Note)=db.notesDao().update(note)
    suspend fun delete(note: Note)=db.notesDao().delete(note)

    fun getNotes(): Flow<List<Note>> = db.notesDao().getAllNotes()

}
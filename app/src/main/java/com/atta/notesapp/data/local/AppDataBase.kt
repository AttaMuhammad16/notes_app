package com.atta.notesapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.atta.notesapp.data.model.Note


@Database(entities=[Note::class], exportSchema = false, version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun notesDao(): NotesDao

    companion object{
        var instance: AppDataBase?=null
        fun getInstance(context:Context): AppDataBase{
            return if (instance==null){
                Room.databaseBuilder(context, AppDataBase::class.java, "Notes").build()
            }else{
                instance!!
            }
        }
    }

}
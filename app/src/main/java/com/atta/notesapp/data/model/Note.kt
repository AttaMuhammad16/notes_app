package com.atta.notesapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "Notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var title:String="",
    var description:String="",
    var time:Long=0
): Parcelable

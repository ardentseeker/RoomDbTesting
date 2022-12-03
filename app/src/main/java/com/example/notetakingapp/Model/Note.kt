package com.example.notetakingapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note(val title:String, val des:String)
{
    @PrimaryKey(autoGenerate = true)
    val id = 0

}
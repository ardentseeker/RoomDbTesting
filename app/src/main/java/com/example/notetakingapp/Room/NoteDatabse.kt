package com.example.notetakingapp.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteDao::class], version = 1)
abstract class NoteDatabse : RoomDatabase(){

    abstract fun getNoteDao():NoteDao

    //singleton

    companion object
    {
        @Volatile
        private var INSTANCE : NoteDatabse? = null

        fun getDatabase(context: Context):NoteDatabse{

            return (INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(context.applicationContext,
                    NoteDatabse::class.java,"note_database").build()

                INSTANCE = instance

                instance
            })

        }
    }

}
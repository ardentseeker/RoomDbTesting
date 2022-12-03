package com.example.notetakingapp.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.notetakingapp.Model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabse : RoomDatabase(){

    abstract fun getNoteDao():NoteDao

    //singleton

    companion object
    {
        @Volatile
        private var INSTANCE : NoteDatabse? = null

        fun getDatabase(context: Context,scope: CoroutineScope):NoteDatabse{

            return (INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(context.applicationContext,
                    NoteDatabse::class.java,"note_database")
                    .addCallback(NoteDatabaseCallback(scope))
                    .build()

                INSTANCE = instance

                instance
            })

        }
    }

    private class NoteDatabaseCallback(private val scope: CoroutineScope):RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { noteDatabse ->

            // noteDatabse.getNoteDao().insert(Note("title","this is on main thread so it will not work"))
                scope.launch {

                    val noteDao = noteDatabse.getNoteDao()
                    noteDao.insert(Note("t1","d1"))
                    noteDao.insert(Note("t2","d2"))
                    noteDao.insert(Note("t3","d3"))
                }
            }
        }
    }

}
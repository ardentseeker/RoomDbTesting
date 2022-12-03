package com.example.notetakingapp.Repository

import androidx.annotation.WorkerThread
import com.example.notetakingapp.Model.Note
import com.example.notetakingapp.Room.NoteDao
import kotlinx.coroutines.flow.Flow

class Repository(private val noteDao: NoteDao) {

    val myAllNote:Flow<List<Note>> = noteDao.getAllNotes()

    @WorkerThread
    suspend fun insert(note:Note){
        noteDao.insert(note)
    }
    @WorkerThread
    suspend fun delete(note:Note){
        noteDao.delete(note)
    }
    @WorkerThread
    suspend fun update(note:Note){
        noteDao.update(note)
    }
    @WorkerThread
    suspend fun deleteAll(){
        noteDao.deleteAll()
    }

}
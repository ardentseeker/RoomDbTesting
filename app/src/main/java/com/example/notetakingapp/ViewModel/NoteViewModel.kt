package com.example.notetakingapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.notetakingapp.Model.Note
import com.example.notetakingapp.Repository.Repository

class NoteViewModel(private val repository: Repository): ViewModel() {

    val myAllNotes:LiveData<List<Note>> = repository.myAllNote.asLiveData()

     suspend fun insert(note: Note) {
        repository.insert(note)
    }
    suspend fun update(note: Note) {
        repository.update(note)
    }
    suspend fun delete(note: Note) {
        repository.delete(note)
    }
    suspend fun deleteAll(note: Note) {
        repository.deleteAll()
    }
}
class NoteViewModelFactory(private var repository: Repository):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)){
            return NoteViewModel(repository) as T
        }else{
            throw IllegalArgumentException("unknown view model")
        }
    }
}
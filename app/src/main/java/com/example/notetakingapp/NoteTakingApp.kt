package com.example.notetakingapp

import android.app.Application
import com.example.notetakingapp.Repository.Repository
import com.example.notetakingapp.Room.NoteDatabse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NoteTakingApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { NoteDatabse.getDatabase(this,applicationScope) }
    val repository by lazy { Repository(database.getNoteDao()) }
}
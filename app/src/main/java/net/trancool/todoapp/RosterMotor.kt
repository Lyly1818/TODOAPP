package net.trancool.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel

class RosterMotor(private val repo: ToDoRepository): ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    val items = repo.items
}
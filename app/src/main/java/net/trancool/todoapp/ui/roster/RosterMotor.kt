package net.trancool.todoapp.ui.roster

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import net.trancool.todoapp.repo.ToDoModel
import net.trancool.todoapp.repo.ToDoRepository

class RosterMotor(private val repo: ToDoRepository): ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getItem() = repo.items

    @RequiresApi(Build.VERSION_CODES.O)
    fun save(model: ToDoModel){
        repo.save(model)
    }



}
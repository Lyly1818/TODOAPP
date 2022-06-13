package net.trancool.todoapp.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import net.trancool.todoapp.repo.ToDoModel
import net.trancool.todoapp.repo.ToDoRepository

class SingleModelMotor(
    private val repo: ToDoRepository,
    private val modelId : String?
    ) : ViewModel(){

    @RequiresApi(Build.VERSION_CODES.O)
    fun  getModel() = repo.find(modelId)

    fun save(model: ToDoModel){
        repo.save(model)
    }

    fun delete ( model: ToDoModel){
        repo.delete(model)
    }
}
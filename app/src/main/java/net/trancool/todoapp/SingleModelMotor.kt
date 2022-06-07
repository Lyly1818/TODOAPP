package net.trancool.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel

class SingleModelMotor(
    private val repo: ToDoRepository,
    private val modelId : String
    ) : ViewModel(){



        @RequiresApi(Build.VERSION_CODES.O)
        fun  getModel() = repo.find(modelId)
}
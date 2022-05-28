package net.trancool.todoapp

import android.os.Build
import androidx.annotation.RequiresApi

class ToDoRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    var items = listOf(
        ToDoModel(
            description = " Buy Coffee",
            isCompleted = true,
            notes = "Amazon.com"
        ),
        ToDoModel(
            description = "Have my hair cut",
            isCompleted = true,
            notes = "Malden"
        ),
        ToDoModel(
            description = "Submit cover letter",
            isCompleted = true,
            notes = "Accenture"
        ),
    )

}
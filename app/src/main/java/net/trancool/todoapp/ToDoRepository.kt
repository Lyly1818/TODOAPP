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

    @RequiresApi(Build.VERSION_CODES.O)
    fun save(model: ToDoModel) {
        items = if (items.any { it.id == model.id }) {
            items.map { if (it.id == model.id) model else it }
        } else {
            items + model
        }
    }


}
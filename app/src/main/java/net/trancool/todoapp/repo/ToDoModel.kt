package net.trancool.todoapp.repo

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.*

data class ToDoModel @RequiresApi(Build.VERSION_CODES.O) constructor(
    val description: String,
    val id: String = UUID.randomUUID().toString(),
    val isCompleted: Boolean = false,
    val notes : String = "",
    val createdOn: Instant = Instant.now()
        )




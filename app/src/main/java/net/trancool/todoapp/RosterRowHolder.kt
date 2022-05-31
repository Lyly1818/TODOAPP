package net.trancool.todoapp

import androidx.recyclerview.widget.RecyclerView
import net.trancool.todoapp.databinding.TodoRowBinding

class RosterRowHolder(private val binding: TodoRowBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(model: ToDoModel) {
        binding.apply {
            isCompleted.isChecked = model.isCompleted
            desc.text = model.description

        }
    }
}
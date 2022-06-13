package net.trancool.todoapp.ui.roster

import androidx.recyclerview.widget.RecyclerView
import net.trancool.todoapp.repo.ToDoModel
import net.trancool.todoapp.databinding.TodoRowBinding

class RosterRowHolder(
    private val binding: TodoRowBinding,
    val checkboxToggle: (ToDoModel) -> Unit,
    val onRowClick: (ToDoModel) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(model: ToDoModel) {
        binding.apply {
            root.setOnClickListener{ onRowClick(model)}

            isCompleted.isChecked = model.isCompleted
            isCompleted.setOnCheckedChangeListener{ _, _ -> checkboxToggle(model)}
            desc.text = model.description


        }
    }
}
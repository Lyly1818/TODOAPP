import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
//import com.commonsware.todo.databinding.TodoRowBinding
import net.trancool.todoapp.RosterRowHolder
import net.trancool.todoapp.ToDoModel
import net.trancool.todoapp.databinding.TodoRowBinding

class RosterAdapter(
    private val inflater: LayoutInflater,
    private val onCheckedboxToggle:(ToDoModel) -> Unit
    ) :
    ListAdapter<ToDoModel, RosterRowHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = RosterRowHolder(
        TodoRowBinding.inflate(inflater, parent, false),
        onCheckedboxToggle
    )

    override fun onBindViewHolder(holder: RosterRowHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private object DiffCallback : DiffUtil.ItemCallback<ToDoModel>() {
    override fun areItemsTheSame(oldItem: ToDoModel, newItem: ToDoModel) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ToDoModel, newItem: ToDoModel) =
        oldItem.isCompleted == newItem.isCompleted &&
                oldItem.description == newItem.description
}

package net.trancool.todoapp.ui.edit

import android.os.Build
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import net.trancool.todoapp.R
import net.trancool.todoapp.repo.ToDoModel
import net.trancool.todoapp.databinding.TodoEditBinding
import net.trancool.todoapp.ui.SingleModelMotor
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class EditFragment : Fragment() {
    private lateinit var binding: TodoEditBinding
    private val args: EditFragmentArgs by navArgs()
    private val motor: SingleModelMotor by viewModel { parametersOf(args.modelId)  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = TodoEditBinding.inflate(inflater, container, false)
        .apply { binding= this }
        .root


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        motor.getModel()?.let {
            binding.apply {
                binding.isCompleted.isChecked = it.isCompleted
                binding.desc.setText(it.notes)
                binding.notes.setText(it.notes)
            }

        }
    }
//
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.actions_edit, menu)
        menu.findItem(R.id.delete).isVisible = args.modelId  != null
        super.onCreateOptionsMenu(menu, inflater)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save -> {

                save()
                return true
            }

            R.id.delete ->{
                delete()
                return true

            }
        }

        return super.onOptionsItemSelected(item)
    }


    @RequiresApi(Build.VERSION_CODES.O)
//    TODO figure out why data  is not being passed to
    private fun save() {
        binding.apply {
            val model = motor.getModel()
            val edited = model?.copy(
                description = desc.text.toString(),
                isCompleted = isCompleted.isChecked,
                notes = notes.text.toString()
            ) ?: ToDoModel(
                description = desc.text.toString(),
                isCompleted = isCompleted.isChecked,
                notes = notes.text.toString()
            )

            edited.let { motor.save(it) }
        }

        navToDisplay()
    }


    private fun navToDisplay(){
        hideKeyBoard()
        findNavController().popBackStack()
    }

    private fun hideKeyBoard(){
        view?.let {
            val imm =  context?.getSystemService<InputMethodManager>()

            imm?.hideSoftInputFromWindow(
                it.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }


    private fun navToList(){
        hideKeyBoard()
//        navigate to rosterListFragment
        findNavController().popBackStack(R.id.rosterListFragment, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun delete(){
        val model = motor.getModel()
        model?.let { motor.delete(it) }
        navToList()

    }


}
package net.trancool.todoapp.ui.display

import android.os.Build
import android.os.Bundle
import android.text.format.DateUtils
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import net.trancool.todoapp.R
import net.trancool.todoapp.databinding.TodoDisplayBinding
import net.trancool.todoapp.ui.SingleModelMotor
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DisplayFragment:Fragment() {
    private val args: DisplayFragmentArgs by navArgs()
    private lateinit var binding: TodoDisplayBinding
    private val motor: SingleModelMotor by viewModel { parametersOf(args.modelId)  }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.actions_display, menu)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = TodoDisplayBinding.inflate(inflater, container, false)
        .apply { binding = this }
        .root


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        motor.getModel()?.let {
            binding.apply {
                completed.visibility = if (it.isCompleted) View.VISIBLE else View.GONE
                desc.text = it.description
                createdOn.text = DateUtils.getRelativeDateTimeString(
                    requireContext(),
                    it.createdOn.toEpochMilli(),
                    DateUtils.MINUTE_IN_MILLIS,
                    DateUtils.WEEK_IN_MILLIS,
                    0
                )
                notes.text = it.notes
            }

        }
//        super.onViewCreated(view, savedInstanceState)
    }


    private fun edit(){
        findNavController().navigate(
            DisplayFragmentDirections.editModel(
                args.modelId
            )
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.edit ->{
                edit()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
package com.atta.notesapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.atta.notesapp.R
import com.atta.notesapp.data.model.Note
import com.atta.notesapp.data.repository.NotesRepository
import com.atta.notesapp.databinding.FragmentAddNoteBinding
import com.atta.notesapp.ui.activities.AddNoteActivity
import com.atta.notesapp.ui.viewModel.MainViewModel
import com.atta.notesapp.ui.viewModel.MainViewModelFactory
import com.atta.notesapp.utils.Utils.showToast
import kotlin.getValue


class AddNoteFragment : Fragment() {
    lateinit var binding: FragmentAddNoteBinding
    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModelFactory(NotesRepository(requireContext()))
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentAddNoteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addNoteBtn.setOnClickListener {
            addNote()
        }
    }

    fun addNote(){
        var title=binding.titleEdt.text.toString()
        var des=binding.descriptionEdt.text.toString()

        if (title.isEmpty()||title.isBlank()){
            showToast(requireContext(),"Add title")
        }else if (des.isEmpty()||des.isBlank()){
            showToast(requireContext(),"Add description")
        }else{
            var note=Note(
                id=0,
                title=title,
                description = des,
                time=System.currentTimeMillis()
            )
            mainViewModel.insertNote(note)
            showToast(requireContext(),"Note Added successfully")
            resetInputFields()
        }
    }

    fun resetInputFields(){
        binding.titleEdt.setText("")
        binding.descriptionEdt.setText("")
    }


}
package com.atta.notesapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atta.notesapp.R
import com.atta.notesapp.data.repository.NotesRepository
import com.atta.notesapp.databinding.FragmentAddNoteBinding
import com.atta.notesapp.ui.activities.AddNoteActivity


class AddNoteFragment : Fragment() {
    lateinit var binding: FragmentAddNoteBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentAddNoteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainLinear.setOnClickListener {
            var intent=Intent(requireContext(), AddNoteActivity::class.java)
            startActivity(intent)
        }
    }
}
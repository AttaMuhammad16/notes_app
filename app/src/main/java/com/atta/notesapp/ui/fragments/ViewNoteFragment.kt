package com.atta.notesapp.ui.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.atta.notesapp.data.repository.NotesRepository
import com.atta.notesapp.databinding.FragmentViewNoteBinding
import com.atta.notesapp.ui.activities.AddNoteActivity
import com.atta.notesapp.ui.adapters.ViewNoteAdapter
import com.atta.notesapp.ui.viewModel.MainViewModel
import com.atta.notesapp.ui.viewModel.MainViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class ViewNoteFragment : Fragment() {
    lateinit var binding: FragmentViewNoteBinding
    lateinit var adapter: ViewNoteAdapter

    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModelFactory(NotesRepository(requireContext()))
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addNoteImg.setOnClickListener {
            startActivity(Intent(requireContext(), AddNoteActivity::class.java))
        }

        adapter = ViewNoteAdapter(requireContext(), mainViewModel)
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle (Lifecycle.State.STARTED){
                mainViewModel.getNotes().collect {
                    adapter.setList(it)
                }
            }
        }

    }


}
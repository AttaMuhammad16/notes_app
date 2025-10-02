package com.atta.notesapp.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atta.notesapp.data.model.Note
import com.atta.notesapp.databinding.NoteItemSampleRowBinding
import com.atta.notesapp.ui.activities.ViewNoteActivity
import com.atta.notesapp.ui.viewModel.MainViewModel
import com.atta.notesapp.utils.Utils.NOTE

class ViewNoteAdapter(
    private var context: Context,
    private var mainViewModel: MainViewModel
) : RecyclerView.Adapter<ViewNoteAdapter.NoteViewHolder>() {

    private var notesList = listOf<Note>()

    class NoteViewHolder(val binding: NoteItemSampleRowBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteItemSampleRowBinding.inflate(LayoutInflater.from(context), parent, false)
        return NoteViewHolder(binding)
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notesList[position]

        holder.binding.apply {
            tvTitle.text = note.title

            main.setOnClickListener {
                var intent = Intent(context, ViewNoteActivity::class.java)
                intent.putExtra(NOTE, note)
                context.startActivity(intent)
            }

            deleteImg.setOnClickListener {
                mainViewModel.deleteNote(note)
            }
        }
    }


    override fun getItemCount(): Int {
        return notesList.size
    }

    fun setList(list: List<Note>) {
        notesList = list
        notifyDataSetChanged()
    }

}
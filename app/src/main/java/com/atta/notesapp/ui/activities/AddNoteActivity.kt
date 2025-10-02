package com.atta.notesapp.ui.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.atta.notesapp.R
import com.atta.notesapp.data.local.AppDataBase
import com.atta.notesapp.data.model.Note
import com.atta.notesapp.data.repository.NotesRepository
import com.atta.notesapp.databinding.ActivityAddNoteBinding
import com.atta.notesapp.ui.viewModel.MainViewModel
import com.atta.notesapp.ui.viewModel.MainViewModelFactory
import com.atta.notesapp.utils.Utils.showToast
import kotlinx.coroutines.launch

class AddNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.closeImg.setOnClickListener {
            finish()
        }


        var repo= NotesRepository(this@AddNoteActivity)
        val viewModel = ViewModelProvider(this, MainViewModelFactory(repo))[MainViewModel::class.java]

        binding.addNoteBtn.setOnClickListener {
            var title=binding.titleEdt.text.toString()
            var des=binding.descriptionEdt.text.toString()

            if (title.isEmpty()||title.isBlank()){
                showToast(this@AddNoteActivity,"Add title")
            }else if (des.isEmpty()||des.isBlank()){
                showToast(this@AddNoteActivity,"Add description")
            }else{
                var note=Note(
                    id=0,
                    title=title,
                    description = des,
                    time=System.currentTimeMillis()
                )
                viewModel.insertNote(note)
                showToast(this@AddNoteActivity,"Note Added successfully")
                finish()
            }
        }


    }
}
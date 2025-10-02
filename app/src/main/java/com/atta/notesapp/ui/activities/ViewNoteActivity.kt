package com.atta.notesapp.ui.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.atta.notesapp.R
import com.atta.notesapp.data.model.Note
import com.atta.notesapp.databinding.ActivityViewNoteBinding
import com.atta.notesapp.utils.Utils.NOTE


class ViewNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backImg.setOnClickListener {
            finish()
        }

        var noteBundle=intent.getParcelableExtra<Note>(NOTE)?:return
        binding.titleTv.text=noteBundle.title
        binding.desTv.text=noteBundle.description

    }
}
package com.atta.notesapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.atta.notesapp.R
import com.atta.notesapp.databinding.ActivityMainBinding
import com.atta.notesapp.ui.adapters.ViewPagerAdapter


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = true


        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.addNotesItem -> binding.viewPager.currentItem = 0
                R.id.viewNotesItem -> binding.viewPager.currentItem = 1
            }
            true
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> binding.bottomNav.selectedItemId = R.id.addNotesItem
                    1 -> binding.bottomNav.selectedItemId = R.id.viewNotesItem
                }
            }
        })


    }
}
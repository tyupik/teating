package com.tyupik.teating.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tyupik.teating.databinding.ActivityMainBinding
import com.tyupik.teating.ui.eating_list.EatingListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
            .also { setContentView(it.root) }

        supportFragmentManager
            .beginTransaction()
            .add(binding.fragmentContainer.id, EatingListFragment())
            .commit()

    }
}
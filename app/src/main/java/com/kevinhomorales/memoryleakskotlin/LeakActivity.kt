package com.kevinhomorales.memoryleakskotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kevinhomorales.memoryleakskotlin.databinding.ActivityLeakBinding

class LeakActivity : AppCompatActivity() {
    lateinit var binding: ActivityLeakBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeakBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpView() {

    }
}
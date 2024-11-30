package com.kevinhomorales.memoryleakskotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.kevinhomorales.memoryleakskotlin.databinding.ActivityMainBinding
import leakcanary.LeakCanary

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        var leakedContext: MainActivity? = null // Referencia estática (causa el memory leak)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpActions()
        setUpView()
    }

    private fun setUpView() {
        leakedContext = this
        LeakCanary.dumpHeap()
    }

    private fun setUpActions() {
        binding.changeTextId.setOnClickListener {
//            openLeakActivity()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun openLeakActivity() {
        val intent = Intent(this, LeakActivity::class.java)
        startActivity(intent)
    }
}
package com.muratmnz.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.muratmnz.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var txtInput: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtInput = findViewById(R.id.resultText)

    }

    fun onDigit(view: View) {
        txtInput?.append((view as Button).text)
    }

    fun onClear(view: View) {
        txtInput?.text = ""
    }
}
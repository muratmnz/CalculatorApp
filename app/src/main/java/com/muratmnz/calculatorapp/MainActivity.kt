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
    var lastNumeric: Boolean = false
    var lastDot: Boolean = false


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
        //flags when clicked every digits
        lastNumeric = true
        lastDot = false
    }

    fun onClear(view: View) {
        txtInput?.text = ""
    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDot) {
            txtInput?.append(".")
            //flags
            lastNumeric = false
            lastDot = true
        }
    }
}
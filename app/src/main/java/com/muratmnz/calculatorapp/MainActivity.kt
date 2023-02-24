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

    fun onOperator(view: View) {
        txtInput?.text?.let {
            // inside if, check txtInput space have must last numeric and there should be no much one operation.
            // this if does not allow add more operations
            if (lastNumeric && !isOperatorAdded(it.toString()))
                txtInput?.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }

    }

    fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/")
                    || value.contains("*")
                    || value.contains("+")
                    || value.contains("-")
        }
    }

    //check last digit is number
    fun onEqual(view: View) {
        if (lastNumeric) {
            var txtValue = txtInput?.text.toString()
            var prefix = ""
            try {
                //if starts number with - and after add second number has - so this solution
                if (txtValue.startsWith("-")) {
                    prefix = "-"
                    txtValue = txtValue.substring(1)
                }

                //split value from operator
                val splitValue = txtValue.split("-")

                var one = splitValue[0]  //first number
                var two = splitValue[1]  //second number

                if (prefix.isNotEmpty()){
                    one = prefix + one
                }

                txtInput?.text = (one.toDouble() - two.toDouble()).toString()

            } catch (e: java.lang.ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

}


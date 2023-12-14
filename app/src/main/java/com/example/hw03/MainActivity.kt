package com.example.hw03

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hw03.R

class MainActivity : AppCompatActivity() {
    private lateinit var num1EditText: EditText
    private lateinit var num2EditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1EditText = findViewById(R.id.num1EditText)
        num2EditText = findViewById(R.id.num2EditText)
        resultTextView = findViewById(R.id.resultTextView)


        // Set click listeners for operator buttons
        findViewById<Button>(R.id.plus).setOnClickListener { calculate('+') }
        findViewById<Button>(R.id.minus).setOnClickListener { calculate('-') }
        findViewById<Button>(R.id.multiply).setOnClickListener { calculate('*') }
        findViewById<Button>(R.id.divider).setOnClickListener { calculate('/') }
        findViewById<Button>(R.id.modulo).setOnClickListener { calculate('%') }
        findViewById<Button>(R.id.clearbutton).setOnClickListener { clearInputs() }
    }


    private fun calculate(operator: Char) {
        val num1 = num1EditText.text.toString()
        val num2 = num2EditText.text.toString()

        if (num1.isBlank() || num2.isBlank()) {
            showToast("กรุณากรอกทั้งสองค่า")
            return
        }

        val operand1 = num1.toDouble()
        val operand2 = num2.toDouble()

        val result = when (operator) {
            '+' -> operand1 + operand2
            '-' -> operand1 - operand2
            '*' -> operand1 * operand2
            '/' -> {
                if (operand2 == 0.0) {
                    showToast("ห้ามหารด้วย 0")
                    return
                }
                operand1 / operand2
            }
            '%' -> {
                if (operand2 == 0.0) {
                    showToast("ห้ามหารด้วย 0")
                    return
                }
                operand1 % operand2
            }
            else -> {
                showToast("เครื่องหมายไม่ถูกต้อง")
                return
            }
        }

        resultTextView.text = "$result"

    }

    private fun clearInputs() {
        num1EditText.text.clear()
        num2EditText.text.clear()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
package com.example.fourbasiccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNum1 = findViewById<EditText>(R.id.editNum1)
        val editNum2 = findViewById<EditText>(R.id.editNum2)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        val textResult = findViewById<TextView>(R.id.textResult)

        fun getNumbers(): Pair<Double, Double>? {
            val num1 = editNum1.text.toString().toDoubleOrNull()
            val num2 = editNum2.text.toString().toDoubleOrNull()

            if (num1 == null || num2 == null) {
                Toast.makeText(
                    this,
                    "숫자를 모두 입력하세요.",
                    Toast.LENGTH_SHORT
                ).show()
                return null
            }

            return Pair(num1, num2)
        }

        btnAdd.setOnClickListener {
            val numbers = getNumbers() ?: return@setOnClickListener
            textResult.text = "결과: ${numbers.first + numbers.second}"
        }

        btnSubtract.setOnClickListener {
            val numbers = getNumbers() ?: return@setOnClickListener
            textResult.text = "결과: ${numbers.first - numbers.second}"
        }

        btnMultiply.setOnClickListener {
            val numbers = getNumbers() ?: return@setOnClickListener
            textResult.text = "결과: ${numbers.first * numbers.second}"
        }

        btnDivide.setOnClickListener {
            val numbers = getNumbers() ?: return@setOnClickListener

            if (numbers.second == 0.0) {
                textResult.text = "결과: 0으로 나눌 수 없습니다."
            } else {
                textResult.text = "결과: ${numbers.first / numbers.second}"
            }
        }
    }
}
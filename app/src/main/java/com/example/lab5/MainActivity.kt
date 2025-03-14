package com.example.lab5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener {
            calculateIncome()
        }

    }

    private fun calculateIncome() {
        val resultsText = findViewById<EditText>(R.id.editTextResults).text.toString()
        val costsText = findViewById<EditText>(R.id.editTextCosts).text.toString()
        val selectedRadioButtonId = findViewById<RadioGroup>(R.id.radioGroup).checkedRadioButtonId

        if (resultsText.isEmpty() || costsText.isEmpty() || selectedRadioButtonId == -1) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            return
        }

        val results = resultsText.toDouble()
        val costs = costsText.toDouble()
        val discountRate = when (selectedRadioButtonId) {
            R.id.radio35 -> 35
            R.id.radio17 -> 17
            R.id.radio64 -> 64
            else -> 0
        }

        val income = (results - costs) * (1 - discountRate / 100.0)

        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("INCOME", income)
        }
        startActivity(intent)
    }
}

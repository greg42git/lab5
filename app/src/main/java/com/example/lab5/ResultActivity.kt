package com.example.lab5

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        val income = intent.getDoubleExtra("INCOME", 0.0)
        val resultText = String.format("Доход: %.2f", income)

        findViewById<TextView>(R.id.textViewResult).text = resultText
    }
}
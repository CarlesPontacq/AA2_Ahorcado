package com.example.ahorcado

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)

        val selectedWord = intent.getStringExtra("SELECTED_WORD") ?: "No word"
        val wordTextView: TextView = findViewById(R.id.wordToGuess)
        wordTextView.text = selectedWord
    }
}
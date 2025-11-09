package com.example.ahorcado

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameplayActivity : AppCompatActivity() {
   private lateinit var wordTextView: TextView
   private lateinit var hiddenWord: String
   private  lateinit var originalWord: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)

        originalWord = intent.getStringExtra("SELECTED_WORD") ?: "No word"

        hiddenWord = createHiddenWord(originalWord)

        wordTextView = findViewById(R.id.wordToGuess)
        wordTextView.text = hiddenWord
    }

    //Chatgpt
    private fun createHiddenWord(word: String): String{
        return buildString {
            for(i in word.indices){
                append("_")
                if(i != word.lastIndex) append(" ")
            }
        }
    }
}
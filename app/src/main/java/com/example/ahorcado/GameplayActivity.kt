package com.example.ahorcado

import Models.LetterAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        val alphabet = ('A'..'Z').toList()
        val row1 = alphabet.subList(0, 5)
        val row2 = alphabet.subList(5, 10)
        val row3 = alphabet.subList(10, 15)
        val row4 = alphabet.subList(15, 20)
        val row5 = alphabet.subList(20, 26)

        setupRecyclerView(findViewById(R.id.recycler_row1), row1)
        setupRecyclerView(findViewById(R.id.recycler_row2), row2)
        setupRecyclerView(findViewById(R.id.recycler_row3), row3)
        setupRecyclerView(findViewById(R.id.recycler_row4), row4)
        setupRecyclerView(findViewById(R.id.recycler_row5), row5)
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

    private fun setupRecyclerView(recyclerView: RecyclerView, letters: List<Char>){
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = LetterAdapter(letters) {letter, button -> checkLetter(letter, button)}
    }

    private fun checkLetter(letter: Char, button: Button){
        button.isEnabled = false
        button.alpha = 0.5f

        val chars = hiddenWord.replace(" ", "").toCharArray()
        var found = false

        for (i in originalWord.indices){
            if(originalWord[i] == letter){
                chars[i] = letter
                found = true
            }
        }

        hiddenWord = chars.joinToString(" ")
        wordTextView.text = hiddenWord

        if(found){

        }
        else{

        }
    }
}
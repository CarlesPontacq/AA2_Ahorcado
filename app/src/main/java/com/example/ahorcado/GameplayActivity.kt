package com.example.ahorcado

import Models.LetterAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
   private  lateinit var hangmanImage: ImageView
   private var imageIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)

        hangmanImage = findViewById(R.id.hangmanImage)

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
        button.alpha = 0.75f

        val chars = hiddenWord.replace(" ", "").toCharArray()
        var found = false

        for (i in originalWord.indices){
            if(originalWord[i] == letter){
                chars[i] = letter
                found = true
            }
        }

        var complete = true
        if(found){
            for(i in originalWord.indices){
                if(chars[i] == '_'){
                    complete = false
                }
            }
        }
        else{
            complete = false
            imageIndex++
            changeImage()
        }

        hiddenWord = chars.joinToString(" ")
        wordTextView.text = hiddenWord

        if(complete){
            goToVictoryScreen()
        }
    }

    private fun goToVictoryScreen(){
        val intent = Intent(this, VictoryActivity::class.java);
        startActivity(intent)
    }

    private fun goToGameOverScreen(){
        val intent = Intent(this, GameOverActivity::class.java);
        startActivity(intent)
    }

    private fun changeImage(){
        when(imageIndex) {
            0 -> hangmanImage.setImageResource(R.drawable.img_hangman_0)
            1 -> hangmanImage.setImageResource(R.drawable.img_hangman_1)
            2 -> hangmanImage.setImageResource(R.drawable.img_hangman_2)
            3 -> hangmanImage.setImageResource(R.drawable.img_hangman_3)
            4 -> hangmanImage.setImageResource(R.drawable.img_hangman_4)
            5 -> hangmanImage.setImageResource(R.drawable.img_hangman_5)
            6 -> hangmanImage.setImageResource(R.drawable.img_hangman_6)
            7 -> hangmanImage.setImageResource(R.drawable.img_hangman_7)
            8 -> hangmanImage.setImageResource(R.drawable.img_hangman_8)
            9 -> hangmanImage.setImageResource(R.drawable.img_hangman_9)
            10 -> hangmanImage.setImageResource(R.drawable.img_hangman_10)
            11 -> hangmanImage.setImageResource(R.drawable.img_hangman_11)
            12 -> goToGameOverScreen()
        }
    }
}
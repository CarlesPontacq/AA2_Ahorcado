package com.example.ahorcado

import Models.Levels
import Models.LevelsAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LevelSelector : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_selector)

        val levels = listOf(
            Levels("Dog"),
            Levels("ENTI"),
            Levels("Hangman"),
            Levels("Aproved"),
            Levels("Excellent"),
            Levels("Level"),
            Levels("House"),
            Levels("Programmer"),
            Levels("Artist"),
            Levels("Sound"),
            Levels("Game"),
            Levels("Soundwave"),
            Levels("Frog"),
            Levels("Pikachu"),
            Levels("Metroid"),
            Levels("Luigi"),
            Levels("Test"),
            Levels("Developer"),
            Levels("Android"),
            Levels("Studio"),

        )

        val recyclerView: RecyclerView = findViewById(R.id.level_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = LevelsAdapter(levels){selectedLevel ->
            val intent = Intent(this, GameplayActivity::class.java)
            intent.putExtra("SELECTED_WORD", selectedLevel.word)
            startActivity(intent)
        }
    }

    private fun onButtonClick(){
        val intent = Intent(this, GameplayActivity::class.java);
        startActivity(intent)
    }
}
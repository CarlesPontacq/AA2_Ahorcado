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
            Levels("DOG"),
            Levels("ENTI"),
            Levels("HANGMAN"),
            Levels("APPROVED"),
            Levels("EXCELLENT"),
            Levels("LEVEL"),
            Levels("HOUSE"),
            Levels("PROGRAMMER"),
            Levels("ARTIST"),
            Levels("SOUND"),
            Levels("GAME"),
            Levels("SOUNDWAVE"),
            Levels("FROG"),
            Levels("PIKACHU"),
            Levels("METROID"),
            Levels("LUIGI"),
            Levels("TEST"),
            Levels("DEVELOPER"),
            Levels("ANDROID"),
            Levels("STUDIO"),

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
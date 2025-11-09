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
            Levels(getString(R.string.level1)),
            Levels(getString(R.string.level2)),
            Levels(getString(R.string.level3)),
            Levels(getString(R.string.level4)),
            Levels(getString(R.string.level5)),
            Levels(getString(R.string.level6)),
            Levels(getString(R.string.level7)),
            Levels(getString(R.string.level8)),
            Levels(getString(R.string.level9)),
            Levels(getString(R.string.level10)),
            Levels(getString(R.string.level11)),
            Levels(getString(R.string.level12)),
            Levels(getString(R.string.level13)),
            Levels(getString(R.string.level14)),
            Levels(getString(R.string.level15)),
            Levels(getString(R.string.level16)),
            Levels(getString(R.string.level17)),
            Levels(getString(R.string.level18)),
            Levels(getString(R.string.level19)),
            Levels(getString(R.string.level20)),

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
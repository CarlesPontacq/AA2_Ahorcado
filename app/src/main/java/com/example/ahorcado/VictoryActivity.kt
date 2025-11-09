package com.example.ahorcado

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VictoryActivity : AppCompatActivity() {
    private lateinit var returnToLevelSelectorScreen : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)

        returnToLevelSelectorScreen = findViewById(R.id.victoryLayout)
        returnToLevelSelectorScreen.setOnClickListener{onButtonClick()}
    }

    private fun onButtonClick(){
        val intent = Intent(this, LevelSelector::class.java);
        startActivity(intent)
    }
}
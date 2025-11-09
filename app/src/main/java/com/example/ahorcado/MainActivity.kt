package com.example.ahorcado

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var changeScene : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeScene = findViewById(R.id.splashScreenVerticalLayout)
        changeScene.setOnClickListener{onButtonClick()}
    }

    private fun onButtonClick(){
        val intent = Intent(this, LevelSelector::class.java);
        startActivity(intent)
    }
}
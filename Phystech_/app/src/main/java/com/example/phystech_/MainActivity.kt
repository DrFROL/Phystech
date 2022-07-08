package com.example.phystech_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageButton : ImageButton

        imageButton = findViewById(R.id.imageButton_lever)

        imageButton.setOnClickListener{
            val intent = Intent(this@MainActivity, Lever::class.java)
            startActivity(intent)
        }
    }
}
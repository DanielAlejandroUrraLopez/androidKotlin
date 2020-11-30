package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*

class KotlinAndroidExtensionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extensions)

        // se carga por el layout
        val btn = findViewById<Button>(R.id.buttonBYId)
        btn.setOnClickListener { Toast.makeText(this, "click by ID", Toast.LENGTH_SHORT).show() }

        // se puede llamar tambien por el kotlix
        buttonNyKat.setOnClickListener { Toast.makeText(this, "click by Kat", Toast.LENGTH_SHORT).show() }

    }
}
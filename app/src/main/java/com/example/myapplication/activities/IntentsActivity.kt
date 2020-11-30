package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        buttonIntentExtras.setOnClickListener { goIntentExtras() }
        buttonIntentFlags.setOnClickListener { goIntentFlags() }
        buttonIntentObject.setOnClickListener { goIntentObject() }
    }

    private fun goIntentExtras(){
        val intent = Intent(this, IntentsActivity::class.java)
        startActivity(intent)
    }

    private fun goIntentFlags(){
        val intent = Intent(this, IntentsActivity::class.java)
        startActivity(intent)
    }

    private fun goIntentObject(){
        val intent = Intent(this, IntentsActivity::class.java)
        startActivity(intent)
    }



}
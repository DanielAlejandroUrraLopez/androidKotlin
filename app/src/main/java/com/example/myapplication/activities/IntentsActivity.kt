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
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.putExtra("name","Daniel")
        intent.putExtra("lastName","Urra")
        intent.putExtra("age",33)
        intent.putExtra("develop",true)

        startActivity(intent)
    }

    private fun goIntentFlags(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY // no guarda el activity en el stack
       //intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION // no animacion
       // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // borrar el stack completo
        startActivity(intent)
       // finish()// destruye este activity evitando que entre en el stack

    }

    private fun goIntentObject(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        startActivity(intent)
    }



}
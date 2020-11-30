package com.example.myapplication.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.myapplication.R

class LifeCycleActivity : LifeCycleEventsActivity() {

    private var exitEnebled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }

    override fun onBackPressed() {
        if(exitEnebled) {
            super.onBackPressed()
        }
        exitEnebled = true;
        Toast.makeText(this,"click back again to exit  this screen", Toast.LENGTH_SHORT).show()
        Handler().postDelayed(Runnable { exitEnebled = false },2000 )
    }
}
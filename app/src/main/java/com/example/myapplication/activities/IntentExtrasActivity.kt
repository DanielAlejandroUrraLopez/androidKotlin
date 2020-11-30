package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_intent_extras.*

class IntentExtrasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        getIntentExtrasFromPreviousActivity()
    }
    private fun getIntentExtrasFromPreviousActivity(){
        val name: String? = intent.getStringExtra("name")
        val lastName: String? = intent.getStringExtra("lastName")
        val age: Int = intent.getIntExtra("age",-1)
        val develop: Boolean = intent.getBooleanExtra("develop",false)

        if(name !== null && lastName !== null && age >=0) {
            textViewName.text = name
            textViewLastName.text = lastName
            textViewAge.text = "$age"
            checkBoxDeveloper.text = "Develop"
            checkBoxDeveloper.isChecked = develop
        }else{
            checkBoxDeveloper.visibility = View.INVISIBLE
        }
    }
}
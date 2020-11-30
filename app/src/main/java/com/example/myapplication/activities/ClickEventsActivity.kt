package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R

class ClickEventsActivity : AppCompatActivity(), View.OnLongClickListener {

    // 1) click en xml
    // 2) click en linea
    // 3) click by dis en 'when'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events)

        // se debe llamar aqui
        clickInLine()

        // capturar los botones del multi
        val btn1 = findViewById<Button>(R.id.buttonClickMulti1)
        val btn2 = findViewById<Button>(R.id.buttonClickMulti2)
        val btn3 = findViewById<Button>(R.id.buttonClickMulti3)

        // se registran los botones y los click al metodo
        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)
    }
    // regla obligatoria para click en xmls
    // el metodo tiene q ser publico , los nombres tiene que coincidir y recibe un colo parametros (view)
    fun xmlClick(view: View){
        Toast.makeText(this, "Click by XML!", Toast.LENGTH_LONG).show()
    }

    private fun clickInLine() {
        val btn = findViewById<Button>(R.id.buttonClickInLine)
        btn.setOnClickListener { Toast.makeText(this, "Click by in line!", Toast.LENGTH_LONG).show() }
    }

    override fun onLongClick(v: View): Boolean {
        when(v.id){
            R.id.buttonClickMulti1 -> Toast.makeText(this, "Click by Multi 1!", Toast.LENGTH_LONG).show()
            R.id.buttonClickMulti2 -> Toast.makeText(this, "Click by Multi 2!", Toast.LENGTH_LONG).show()
            R.id.buttonClickMulti3 -> Toast.makeText(this, "Click by Multi 3!", Toast.LENGTH_LONG).show()
        }
        return true;
    }


}
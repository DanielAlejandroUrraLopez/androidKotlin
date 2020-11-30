package com.example.myapplication.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso.*

class PicassoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)


        buttonLoader.setOnClickListener { loadImages() }

        Picasso.with(this).load("https://i.pinimg.com/564x/d8/0c/bd/d80cbdcf865cf7da2c196e5761ffc35b.jpg").fetch()

    }

    private fun loadImages(){
        Picasso.with(this)
            .load("https://i.pinimg.com/564x/d8/0c/bd/d80cbdcf865cf7da2c196e5761ffc35b.jpg")
            //.fit()
            .resize(600,600)
            .centerInside()
            .into(imageViewTop)

        /*Picasso.with(this)
            .load("https://i.pinimg.com/originals/e9/91/51/e991519e535e4558f155a4533f119b7a.jpg")
            //.fit()
            .resize(600,600)
            .centerInside()
            .into(imageViewBotton)*/

        /*Picasso.with(this)
            .load("https://i.pinimg.com/originals/e9/91/51/e991519e535e4558f155a4533f119b7a.jpg")
            .fit()
            .transform(CircleTrasForm()) //renderizar como un circulo
            .into(imageViewBotton)*/

        val context: Context = this

        Picasso.with(this)
            .load("https://i.pinimg.com/originals/e9/91/51/e991519e535e4558f155a4533f119b7a.jpg")
            .fetch(object: Callback {
                override fun onSuccess() {
                    imageViewBotton.alpha = 0f
                    Picasso.with(context)
                        .load("https://i.pinimg.com/originals/e9/91/51/e991519e535e4558f155a4533f119b7a.jpg")
                        .fit()
                        .into(imageViewBotton)

                    imageViewBotton.animate().setDuration(3000).alpha(1f).start()
                }

                override fun onError() {
                    TODO("Not yet implemented")
                }

            })



    }
}
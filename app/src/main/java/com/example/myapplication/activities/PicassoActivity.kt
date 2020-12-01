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

        Picasso.with(this).load("https://st4.depositphotos.com/2435561/23030/i/1600/depositphotos_230304352-stock-photo-red-sign-night-chinatown-milan.jpg").fetch()

    }

    private fun loadImages(){
        Picasso.with(this)
            .load("https://st4.depositphotos.com/2435561/23030/i/1600/depositphotos_230304352-stock-photo-red-sign-night-chinatown-milan.jpg")
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
            .load("https://st4.depositphotos.com/2435561/23030/i/1600/depositphotos_230304352-stock-photo-red-sign-night-chinatown-milan.jpg")
            .fetch(object: Callback {
                override fun onSuccess() {
                    imageViewBotton.alpha = 0f
                    Picasso.with(context)
                        .load("https://st4.depositphotos.com/2435561/23030/i/1600/depositphotos_230304352-stock-photo-red-sign-night-chinatown-milan.jpg")
                        .fit()
                        .into(imageViewBotton)

                    imageViewBotton.animate().setDuration(3000).alpha(1f).start()
                }

                override fun onError() {
                }

            })



    }
}
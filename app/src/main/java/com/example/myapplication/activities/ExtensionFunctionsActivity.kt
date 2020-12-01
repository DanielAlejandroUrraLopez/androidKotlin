package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.others2.goToActivity
import com.example.myapplication.others2.loadByUrl
import com.example.myapplication.others2.snackBar
import com.example.myapplication.others2.toast
import kotlinx.android.synthetic.main.activity_extension_functions.*

class ExtensionFunctionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)

        // el texto como string
        //buttonToast.setOnClickListener { toast("hola") }
        // llamandolo de lo sstring del archivo con lo snobres de botnos
        //buttonToast.setOnClickListener { toast(getString(R.string.button_kat_id)) }
        //pasarle el resource directo
        //buttonToast.setOnClickListener { toast(getString(R.string.button_kat_id)) }

        buttonToast.setOnClickListener { toast("hola") }
        // solo mensaje y duracion por defecto
        //buttonSnackBar.setOnClickListener { snackBar("hola")  }
        //mensaje con una accion y un mnesaje d ela accion y duracion por defecto
        //buttonSnackBar.setOnClickListener { snackBar("hola", action = "Undo"){ toast("undo") }  }
        buttonSnackBar.setOnClickListener { snackBar("hola")  }
        buttonLoadByUrl.setOnClickListener { imageViewLoadedByURL.loadByUrl("https://st4.depositphotos.com/2435561/23030/i/1600/depositphotos_230304352-stock-photo-red-sign-night-chinatown-milan.jpg") }
        buttonGoToActivity.setOnClickListener { goToActivity<MainActivity>{ putExtra("id" , 1) } }
    }
}
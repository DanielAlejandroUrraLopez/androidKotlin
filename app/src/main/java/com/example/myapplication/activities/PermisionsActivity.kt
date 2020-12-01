package com.example.myapplication.activities


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_permisions.*



class PermisionsActivity : AppCompatActivity() {

    private val requestCameraPermission = 100
    private val requestCameraPicture = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisions)

        buttonPicture.setOnClickListener({ getPictureFromCamera() })
    }

    private fun getPictureFromCamera(){
        // asegurarnos de que no  hay permiso de camara en manifest
        // crear intent para capturar la foto
        val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        // comprobar si podemos menejar la captura de fotos (tenemos camara y app de camara)
        if(pictureIntent.resolveActivity(packageManager) != null){

            startActivityForResult(pictureIntent,requestCameraPicture)

        }else{
            // no hay activity que pueda manejar el intent (por ejemplo sin camara)
            Toast.makeText(
                this,
                "Error!!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun getPictureFromCameraAskingPermissions() {
        //añadir permiso al manifest
        //comprobar el permiso d ela camara
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // se no ha sido aceptado previamente (para version desde la 6.0 [api 23] en adelante)
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA),
                requestCameraPermission
            )
        } else {
            // si ha sido aceptado previamente (para las version inferiores a las 6.0 [api 23])
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, requestCameraPicture)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            requestCameraPermission -> {
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //permiso aceptado
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, requestCameraPicture)

                } else {
                    // permiso denegado
                    Toast.makeText(
                        this,
                        "you can't take a picture if you dan't allow it",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }
    }
    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            requestCameraPicture -> {
                // Comprobar si el resultado es bueno
                if (resultCode == Activity.RESULT_OK) {
                    // Obtenemos los extras del intent recibido por parametros
                    val extras = data!!.extras
                    // Formamos el bitmap a partir de los extras
                    val imageBitMap = extras.get("data") as Bitmap
                    // Cargamos la foto como bitmap en el imageView
                    imageViewPicture.setImageBitmap(imageBitMap)
                } else {
                    // La foto no ha sido tomada con éxito
                    Toast.makeText(this, "Picture has failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
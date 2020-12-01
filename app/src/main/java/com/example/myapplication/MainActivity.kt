package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.activities.*
import com.example.myapplication.others2.ToolbarActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)*/

        toolbarToLoad(toolbar as Toolbar)


        //Variables().showCases()
        //Operators().showHolas()
        //Classes().showHolas()
        //Functions().showHolas()
        //CompanionObject().showHolas()

        val btnLifeCycle = findViewById<Button>(R.id.button_to_cycle)
        val btnClickEvents = findViewById<Button>(R.id.button_to_click)
        val btnAndroidExtension = findViewById<Button>(R.id.button_to_android_extensions)
        val btnPicasso = findViewById<Button>(R.id.button_to_picasso)
        val btnListView = findViewById<Button>(R.id.button_to_list_view)
        val btnIntents = findViewById<Button>(R.id.button_to_intents)
        val btnPermission = findViewById<Button>(R.id.button_to_permissions)
        val btnSharedPreferences = findViewById<Button>(R.id.button_to_shared_preferences)
        val btnExtensionFunctions = findViewById<Button>(R.id.button_to_extension_functions)

        btnLifeCycle.setOnClickListener { goToCycleActivity()}
        btnClickEvents.setOnClickListener { goToClickEventsActivity() }
        btnAndroidExtension.setOnClickListener { goToAndroidExtension() }
        btnPicasso.setOnClickListener { goToPicassoActivity() }
        btnListView.setOnClickListener { goToListViewActivity() }
        btnIntents.setOnClickListener { goToIntentsActivity() }
        btnPermission.setOnClickListener { goToPermissionActivity() }
        btnSharedPreferences.setOnClickListener { goToSharedPreferencesActivity() }
        btnExtensionFunctions.setOnClickListener { goToExtensionFunctionsActivityActivity() }

    }


        fun showToast() {
            Toast.makeText(this, "hola from toast", Toast.LENGTH_LONG).show()
        }

        fun showSnackBar() {
            val layout = findViewById<ConstraintLayout>(R.id.constraint)
            //Snackbar.make(layout,"hello fromsnackbar",Snackbar.LENGTH_LONG).show()
            Snackbar.make(layout, "hello fromsnackbar", Snackbar.LENGTH_LONG).setAction("undo") {
                Snackbar.make(layout, "Email has been restored", Snackbar.LENGTH_LONG).show()
            }.show()
        }

        private fun goToCycleActivity() = startActivity(Intent(this,LifeCycleActivity::class.java))
        private fun goToClickEventsActivity() = startActivity(Intent(this, ClickEventsActivity::class.java))
        private fun goToAndroidExtension() = startActivity(Intent(this,KotlinAndroidExtensionsActivity::class.java))
        private fun goToPicassoActivity() = startActivity(Intent(this, PicassoActivity::class.java))
        private fun goToListViewActivity() = startActivity(Intent(this, ListViewActivity::class.java))
        private fun goToIntentsActivity() = startActivity(Intent(this, IntentsActivity::class.java))
        private fun goToPermissionActivity() = startActivity(Intent(this,PermisionsActivity::class.java))
        private fun goToSharedPreferencesActivity() = startActivity(Intent(this,SharedPreferencesActivity::class.java))
        private fun goToExtensionFunctionsActivityActivity() = startActivity(Intent(this,ExtensionFunctionsActivity::class.java))


}
package com.example.myapplication.others

import android.util.Log

class CompanionObject {

    private fun hola(){
        //normal companion Object
        val value = MyClass1.flag
        MyClass1.welcome()
    }

    private fun hola0(){
        // implementando interfaz en companion object
        MyClass2.welcome()

    }

    fun showHolas(){
        hola()
        hola0()
    }
}
class MyClass1{
    companion object{
        val flag = 1

        fun welcome(){
            Log.w("companion-object-1 "," welcome fropm companion object! ")
        }
    }

}
class MyClass2{
    companion object: Welcome{
        override fun welcome() {
            Log.w("companion-object-2 "," welcome fropm companion object + interface! ")
        }


    }

}
interface Welcome{
    fun welcome()
}
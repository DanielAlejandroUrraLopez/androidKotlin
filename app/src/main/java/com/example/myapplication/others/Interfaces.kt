package com.example.myapplication.others

import android.util.Log

class Interfaces {

    private var anonymousObjectImplementingInterface: Any? = null

    private fun hola(){

        anonymousObjectImplementingInterface = object  : Interface1{
            override fun abstractMethod() {
                // poner codigo es total mente opcional
            }

        }
        // necesitamos castear ya que en la declaracion l ohacemos cono Any y no puede inferir el tipo correctamente
        (anonymousObjectImplementingInterface as Interface1) .methodWithImplementationByDefault()
        (anonymousObjectImplementingInterface as Interface1) .abstractMethod()
    }

    private fun hola0(){

        val aoii = object : Interface2{
            override val propertyAbstract: Int
                get() = 10
        }

        aoii.propertyAbstract
        aoii.propertyWithImplementation
        aoii.hello()
    }

    fun showHolas(){
        hola()
        hola0()
    }

}

interface Interface1{

    fun abstractMethod()
    fun methodWithImplementationByDefault(){

    }

}

interface Interface2{

    val propertyAbstract: Int
    var propertyWithImplementation: String
        get() = "byDefault"
        set(value) { this.propertyWithImplementation = value }

    fun hello(){
        Log.w("interface-2", "esta fun cionando por defecto $propertyWithImplementation?, yay ! $propertyAbstract :)")
    }

}
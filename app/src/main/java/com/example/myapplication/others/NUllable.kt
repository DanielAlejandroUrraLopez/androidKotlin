package com.example.myapplication.others

import java.lang.NullPointerException

class NUllable {
    /*
    * operadores relacionados con la nulabilidad
    * - onloy-safe (?)
    * -non-null asserted (!!)
    *  sistema de tipado de kotlin esta pensadopara eliminar de nuestro codigo el nullpointerexception.
    * los 4 unicos posibles casos para NPE son:
    *
    * 1) una llamada explicita al erro nullpointExcepotion()
    * 2) uso del operador !!
    * 3) codigo externo java
    * 4) alguna inconsistencia de datos enb relacion a la inicializacion
    * */

    private lateinit var variable1:String
    private var variable2:String?=null

    private fun hola() {
        throw NullPointerException()
    }
    private fun hola0(var1: String?){

        var1.toString()// devuelve null en caso de que var1 sea null
        var1!!.toString()//se cae si el valor es null
        //var1?.toString()
    }
    private fun hola1(){

        Other.getNPE()// devuelve un NPE

    }
    private fun hola2(){
        variable1.length // esto devuelve un null
        variable2?.length // podria ser null
        variable2!!.length // si fuera null se cae


    }
    fun showNullable(){
        hola()
        hola0("")
        hola1()
        hola2()

    }
}
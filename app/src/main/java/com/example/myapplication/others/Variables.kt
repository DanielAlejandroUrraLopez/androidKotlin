package com.example.myapplication.others

import android.util.Log

/*
todo es un objeto.
no hay tipos basicos y no existe void. si algo no devuelve nada esta devolviendo unit object.
las variable spueden ser mutables o unmutables, usaremos inmutables qiempre q sea posible.(vas vs val).
los tipos son definidos despues del nombre de la variable con dos puntols y espacio (var nombre: tipo)


* */


class Variables {

    private var variable0 = 1
    private var variable1 = 1.toByte()
    private var variable2 = -123
    private var variable3 = 2147483648
    private var variable4 = 1.1.toFloat()
    private var variable5 = 1.1
    private var variable6 = 'a'
    private var variable7 = "abcd"
    private var variable8 = true
    private var variable9 = arrayOf(1,2,3,4,5)
    private var variable10 = arrayOfNulls<Int>(10)//[null,null] solo aceptara int
    private val variable11 = "esta variable es read-only o inmutable"


    //show case para byte
    public fun hola0(){
        Log.w("variable-0 "," es variable 0 un int? --->> "+(variable0 is Int) + " y porque no un byte? ")
        Log.w("variable-1 "," es variable 0 un Byte? --->> "+(variable1 is Byte) + " y porque no un byte? ")
    }

    //show case para byte
    public fun hola1(){
        Log.w("variable-2 ","es un valor Int")
        variable2 = Int.MAX_VALUE
    }

    //show case para long
    public fun hola2(){
        Log.w("variable-3","es un valor long?" +(variable3 is Long))
    }

    //show case para float
    public fun hola3(){
        Log.w("variable-4","es un valor float?" +(variable4 is Float))
    }

    //show case para Double
    public fun hola4(){
        Log.w("variable-5","es un valor double?" +(variable5 is Double))
    }

    //show case para char
    public fun hola5(){
        Log.w("variable-6","es un valor char?" +(variable6 is Char))
    }

    //show case para string
    public fun hola6(){
        Log.w("variable-7","es un valor string?" +(variable7 is String))
        // String literals
        variable7 ="hola mundo\nadios mundo"// esto en java style
        variable7 ="""
            hola mundo 
            adios mundo
            """// en kotlin

        //String templates
        var points = 9
        var maxPoints = 10

        variable7 ="hola tengo " + points + " sobre "+ maxPoints // en java

        variable7 ="hola tengo $points sobre $maxPoints " // kotlin

        variable7 ="hola tengo ${points + 10 } sobre ${maxPoints + 10 } " // kotlin con funcion matematica


    }

    //show case para boolean
    public fun hola7(){
        Log.w("variable-8","es un valor Boolean?" +(variable8 is Boolean))
    }

    //show case para array de Int
    public fun hola8(){
        Log.w("variable-9","es un valor array de int?" +(variable9 is Array<Int>))
    }

    //show case para array de Int
    public fun hola9(){
        Log.w("variable-9","es un valor array de int?" +(variable9 is Array<Int>))
    }

    //show case para array de Int?
    public fun hola10(){
        Log.w("variable-10","es un valor array de int? ?" +(variable10 is Array<Int?>))

        variable10 = arrayOfNulls(3)
        variable10 = arrayOf(1,2,3,4)

        variable10[0]?.toFloat() //safe calls en caso de ser  null retorna null
        variable10[0]?.toFloat() ?: "Error" //elvis operator en caso de ser  null retorna null
        variable10[0]!!.toFloat() //el !! cuadno estanmos euros  que no puede ser null si lo fuera se cae

}
    fun showCases(){
        hola0()
        hola1()
        hola2()
        hola3()
        hola4()
        hola5()
        hola6()
        hola7()
        hola8()
        hola9()
        hola10()
    }


}
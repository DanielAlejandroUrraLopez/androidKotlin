package com.example.myapplication.others

import android.util.Log

class ControlFlow{

    private fun hola(){
        //if

        val num1 = 5
        val num2 = 10

        if(num1 > num2){
            Log.w("control-flow-1","num1 es mayor que num2")
        }
        if(num2 > num1){
            Log.w("control-flow-1","num2 es mayor que num1")
        }

    }
    private fun hola0(){
        //if else

        val num1 = 5
        val num2 = 10

        if(num1 > num2){
            Log.w("control-flow-1","num1 es mayor que num2")
        }else{
            Log.w("control-flow-1","num2 es mayor que num1")
        }
// como exprecion
        if(num1 > num2)Log.w("control-flow-1","num1 es mayor que num2") else Log.w("control-flow-1","num2 es mayor que num1")
        val result = if(num1 > num2) num1 else num2
    }
    private fun hola1(){
        // when lo que seria switch en java

        val x = 1

        //con argumentos (x)
        when (x){
            1 -> Log.w("control-flow-3"," x === 1 ")// case 1
            2 -> Log.w("control-flow-3"," x === 2 ")// case 2
            3-> Log.w("control-flow-3"," x === 3 ")// case 3
            else -> Log.w("control-flow-3"," x es otro numero ")// case default, no es obligatorio

        }

        when (x){
            0,1 ->Log.w("control-flow-3"," x === 0 o x === 1")//case 0 o 1
        }

        //sin argumento (x)
        when {
            (x % 2 == 0) -> Log.w("control-flow-3"," el numero es par ")
            (x % 2 == 1) -> Log.w("control-flow-3"," el numero es impar ")
        }

        // din argumento y devolviendo un valor
        var esPAr = when{
            (x % 2 == 0) -> true
            else -> false
        }

    }
    private fun hola2(){
        // bucle for

        val numbers = arrayOf(1,2,3,4,5)

        for (number in numbers)
            Log.w("control-flow-4",number.toString())

        // especificando el tipo
        for (number : Int in numbers){
            Log.w("control-flow-4",number.toString())
        }

        // con indices
        for((index,number) in numbers.withIndex()){
            Log.w("control-flow-4","$index: $number")
        }

    }
    private fun hola3(){
        // while & do while

        var x = 10

        while (x > 0){
            Log.w("control-flow-5", x--.toString())
        }

        do{
            Log.w("control-flow-5", "Primera y unica iteracion")
        }while(x > 0)

    }

    fun showHolas(){

        hola()
        hola0()
        hola1()
        hola2()
        hola3()
    }
}
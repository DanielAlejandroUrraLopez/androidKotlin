package com.example.myapplication.others

import android.util.Log
import java.util.*

class Functions {

    private fun hola(){
        // funciones parametros y unit

        fun function1(){}
        val result1 = function1()

        fun function2(): Unit{}
        val result2: Unit = function2()

        //los parametros de las funciones necesitan especificar su tipo siempre
        fun function3(param1: String, param2: String): String{
            return "$param1,$param2"
        }

        val result3 = function3("pepe","daniel")

        fun function4(param: Int = 5){}
        fun function5(param: Int?){}
    }

    private fun hola0(){
        // funciones con funciones como apametros(callback) y llamadas por lambda
        fun printSum(num1: Int,num2: Int,printer: ( result: Int) -> Unit){
            printer(num1 + num2)
        }
        
        printSum(5,5){ result ->
            Log.w("function-2", "lambda expression printing the sum result (10) ==> $result")
            
        }

        // si el callback recibe solo un parametro podemos omitir ese "result" --> it

        printSum(12,12){
            Log.w("function-2", "lambda expression printing the sum result (24) ==> $it")

        }

        fun printSum2(num1: Int,num2: Int,printer: ( result: Int, param1: Int, param2: Int) -> Unit){
            printer(num1 + num2,num1,num2)
        }

        printSum2(7,7){ result, param1, param2 ->
            Log.w("function-2", "lambda expression printing the sum result (14) ==> $result")

        }

        printSum2(7,7){ result, _, _ ->
            Log.w("function-2", "lambda expression printing the sum result (14) ==> $result")

        }


    }

    private fun hola1(){
        // named aeguments

        fun function1(firstName: String, lastName: String,age: Int,city: String,dateOfBirth: Date){
            //
        }

        function1("","",27,"", Date())
        function1(age = 33, dateOfBirth = Date(), firstName = "kk", lastName = "pp",city = "")

    }

    private fun hola2(){
        // single expresion functions
        fun sum1(param1: Int, param2: Int): Int {
            return param1 +param2
        }

        fun sum2(param1: Int, param2: Int) = param1 + param2

    }

    private fun hola3(){
        //variable number of arguments (varargs)
        fun sumAll(vararg numbers: Int) = numbers.sum()

        val result = sumAll(1,2,3,4,5,6,7,8,9,10)

        Log.w("function-5 "," vararg result is 55 ==> $result")


    }

    private fun hola4(){
        // extension functions

        // si es declarada dentro de este metodo solo tenemos acceso a el en este mismo contexto de funcion
        fun String.welcome(){
            Log.w("function-6 "," bienvenidos a kotlin extension functions!")
        }

        "".welcome()

    }

    fun showHolas(){
        hola()
        hola0()
        hola1()
        hola2()
        hola3()
        hola4()
        // se puede llamar de cualquier parte del proyecto
        "".welvomeKotlin()
    }


}

fun String.welvomeKotlin(){
    Log.w("function-6 "," bienvenidos a kotlin extension functions globally!")
}
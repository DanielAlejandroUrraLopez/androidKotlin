package com.example.myapplication.others

import android.util.Log

class Operators {
    private fun hola(){

        var a = 5
        var b = 5

        Log.w("operators-1", "referential equality . es 'a' igual a 'b' ? ${a===b}")// true
        Log.w("operators-1", "structural equality . es 'a' igual a 'b' ? ${a==b}")//true
    }
    private fun hola0(){

        val pn1 = PersonNormal()
        val pn2 = PersonNormal()

        Log.w("operators-2", "referential equality . es 'pn1' igual a 'pn2' ? ${pn1 === pn2}")//false
        Log.w("operators-2", "structural equality . es 'pn1' igual a 'pn2' ? ${pn1 == pn2}")//false, por que no sobre escribe equals

    }
    private fun hola1(){

        val pn1 = PersonEqualsOverride()
        val pn2 = PersonEqualsOverride()

        Log.w("operators-3", "referential equality . es 'pn1' igual a 'pn2' ? ${pn1 === pn2}")//false
        Log.w("operators-3", "structural equality . es 'pn1' igual a 'pn2' ? ${pn1 == pn2}")//true
    }
    private fun hola2(){

        val pn1 = PersonDataClass()// daniel 27
        val pn2 = PersonDataClass()// daniel 27
        val pn3 = PersonDataClass("roberto")// roberto 27

        Log.w("operators-4", "referential equality . es 'pn1' igual a 'pn2' ? ${pn1 === pn2}")//false
        Log.w("operators-4", "structural equality . es 'pn1' igual a 'pn2' ? ${pn1 == pn2}")//true
        Log.w("operators-4", "structural equality . es 'pn1' igual a 'pn3' ? ${pn1 == pn3}")//false

    }

    fun showHolas(){
        hola()
        hola0()
        hola1()
        hola2()
    }

    class PersonNormal {val name = "Daniel"}
    class PersonEqualsOverride {
        val name = "Daniel"
        override fun equals(other: Any?): Boolean {
            if(other === null){
                return false
            }
            if(other is PersonEqualsOverride){
                return other.name === this.name
            }
            return false
        }
    }

    data class PersonDataClass(val name: String = "Daniel",val age: Int = 27)


}
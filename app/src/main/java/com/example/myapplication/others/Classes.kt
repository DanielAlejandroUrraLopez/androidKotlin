package com.example.myapplication.others

import android.util.Log
import java.time.DayOfWeek

// clases son publicas y final por defecto
//si queremos que una clase se pueda ser heredada, usaremos ope (open class xxx)

class Classes{

    private fun hola(){
        // clase en kotlin pueden tener un constructor primario y uno o mas contrcutores secundarios
        // primario se encuentra en la firma de la declaracion d ela clase.
        // secundario se encuentra dentro de la declaracion de la classe

        //contructores primarios
        class Person1
        class Person2 constructor(var firsName:String)// constructor primario
        class Person3 (var firsName:String)// la palabra "constructor" puede ser omitido
        class Person4( val firstName:String, val lastName: String,var age:Int){
            init{
                age = 10
            }
        }

        class Person5(val firstName: String ="Daniel", val lastName: String = "Urra",var age: Int = 33)

        // para crear instancias de objectos no usamos la palabra "new"
        val p1 = Person1()
        val p2 = Person2("Daniel")
        val p3 = Person3("Daniel")
        val p4 = Person4("Daniel","Urra",33 )
        val p5_1 = Person5("pepe","perez",50)
        val p5_2 = Person5()
        val p5_3 = Person5(firstName = "tutu")
        val p5_4 = Person5(age = 50,lastName = "kk",firstName = "tt")

    }

    private fun hola0(){

        //clases en kotlin puede tener un constructor primario y uno o mas contructores segundareios
        //primario se encuentra en la firma de la declaracion de la clase
        //secundario se encuentra dentro d ela declaracion d ela clase

        // constructores secundarios (son menos usados en kotlin)

        open class Person{
            constructor(firstName: String, lastName: String){
                Log.w("clases-2","welcome $firstName $lastName!")
            }
        }

        class Person1: Person{
            constructor(firstName: String): super(firstName,"lora")
            constructor(firstName: String,lastName: String): super(firstName,lastName)
        }

        val p = Person1("pepe","lora")
        // no tenemos acceso a peron.firstName, ver hola3
    }

    private fun hola1(){
        // diferencia entre init y contructor secundario
        class Person1{
            // init se va a ejecutar antes que el constructor secundario y despues que el contructor primario
            init{
                Log.w("clases-3","welcome from init!")//no puedes acceder a firstName o lastName
            }
            constructor(firsttName: String, lastName: String){
                Log.w("clases-3","welcome from secondary constructor!")
            }

        }

        class Person2(firsttName: String, lastName: String){
            init{
                //aqui si podemos acceder a las propiedades cpnservando init y constructor secundario
            }
            constructor(): this("Daniel","urra")
        }
        val p1 = Person1("Daniel","urra")
        val p2 = Person2("roberto","perez")
        val p3 = Person2() //Daniel urra
    }

    private fun hola2(){
    //val var o nada en el constructor?
      class Person1(firstName: String)//no puedes acceder a firstName cuando crees la instancia
      class Person2(var firstName: String)//puedes acceder firstName cuando crees la instancia y puedes cambiar su valor
      class Person3(val firstName: String)//puedes acceder firstName cuando crees la instancia y no puedes cambiar su valor

        val p1 = Person1("")
        val p2 = Person2("")
        val p3 = Person3("")

        //p1.firstName // Error
        p2.firstName // Error
        p3.firstName // Error
    }

    private fun hola3(){
        // propeties - getters & setters
        class Person1(var firstName: String)

        val p1 = Person1("Daniel")
        p1.firstName // seria el equivalente a getFirstName()
        p1.firstName = "pepe" //seria el equivalente a setFirstName("pepe")

        class Person2{
            // field - representa a la propiedad nunca usar this.propiedad
            var firstName: String
                get() = field.capitalize()
                set(value) {
                    field = value.capitalize()
                }

            constructor(firstName: String,lastName: String){
                this.firstName = firstName
               // this.lastName = lastName
            }
        }


    }

    private fun hola4(){
        // herencia e interfaces
        open class Person1(var name: String)
        open class Person2(open var name: String)
        open class Person3(open var name: String)

        // si heredamos de Person1, las propiedades no se pueden llamar de igual forma entre padre e hijo
        //class Persona11(var name: String ) :Persona1(name)
        // podemos mantener ambas con el mismo nombre pero tenemnos que agregar open y override
        class Person22(override var name: String) : Person2(name)

        // todo junto
        class Person33(override var name:  String, override  var age: Int ) : Person3(name),IPerson{

            override fun hello() {}
        }

    }

    private fun hola5(){
        // override y super
        abstract class Person(open var firstName: String, open var lastName: String){
            abstract fun hello()

            fun welcomeKotlin(){
                Log.w("clases-7","bienvenido a kotlin!")
            }

            open fun welcomeDevelopers(){
                Log.w("clases-7","bienvenido a developers!")
            }
        }

        class Man(override var firstName: String, override var lastName: String): Person(firstName,lastName) {
            override fun hello() {
                Log.w("clases-3","hola , yo soy $firstName $lastName")
            }
            override  fun welcomeDevelopers(){
                super.welcomeDevelopers()
                super.welcomeKotlin()
                Log.w("clases-3","hola ")
            }
        }

        val man = Man("Daniel","Urra" )
        man.hello()
        man.welcomeDevelopers()
        man.welcomeKotlin()
    }

    private fun hola6(){
        // data clases
        // segun la documentacion oficial para hacer uso correcto de la data clasess debe:
        // el constructor primario necesita tener al menos 1 parametro
        // todos los parametros del constructor primario deben ser marcados como "val o "var"
        // data clases no pueden ser "abstract, open ,seaked o iner "

        data class Person(var firstName: String , var lastName: String)

        val p = Person("Daniel","urra")
        val p2 = p
        val PersonString = p.toString()
        val personCopy = p.copy()
        val clone = p.copy(firstName = "jose" )
        val (firstName,lastName) = p // destructuring

        Log.w("clases-8","data class toString() ==> $PersonString ")
        Log.w("clases-8","data class copy() ==> $personCopy ")
        Log.w("clases-8","p must be same reference than  p2 ==> ${ p === p2 } ") // true referential equality
        Log.w("clases-8","p must be different reference than  personCopy ==> ${ p !== personCopy } ") // true referential equality
        Log.w("clases-8","p must have same proprty values than personCopy ==> ${ p == personCopy } ") // true Structural equality
        Log.w("clases-8","p must be different properties values clone ==> ${ p !== clone } ") // true referential equality
        Log.w("clases-8","p must be different reference than  clone ==> ${ p != clone } ") // true Structural equality
        Log.w("clases-8","firstName by destructuring must be 'Daniel' ==> $firstName ")
        Log.w("clases-8","lastName by destructuring must be 'Daniel' ==> $lastName ")



    }

    private fun hola7(){
        // enum classes
        Log.w("clases-9","ENUM SayOfWeek.LUNES should be name ==> ${DayOfWek.LUNES.name}")
        Log.w("clases-9","ENUM SayOfWeek.LUNES should be ordinal ==> ${DayOfWek.LUNES.ordinal}")
        Log.w("clases-9","ENUM SayOfWeek.MARTES should be name ==> ${DayOfWek.MARTES.name}")
        Log.w("clases-9","ENUM SayOfWeek.MARTES should be ordinal ==> ${DayOfWek.MARTES.ordinal}")
        Log.w("clases-9","ENUM SayOfWeek.MIERCOLES should be name ==> ${DayOfWek.MIERCOLES.name}")
        Log.w("clases-9","ENUM SayOfWeek.MIERCOLES should be ordinal ==> ${DayOfWek.MIERCOLES.ordinal}")
        Log.w("clases-9","ENUM SayOfWeek.JUEVES should be name ==> ${DayOfWek.JUEVES.name}")
        Log.w("clases-9","ENUM SayOfWeek.JUEVES should be ordinal ==> ${DayOfWek.JUEVES.ordinal}")
        Log.w("clases-9","ENUM SayOfWeek.VIERNES should be name ==> ${DayOfWek.VIERNES.name}")
        Log.w("clases-9","ENUM SayOfWeek.VIERNES should be ordinal ==> ${DayOfWek.VIERNES.ordinal}")
        Log.w("clases-9","ENUM SayOfWeek.SABADO should be name ==> ${DayOfWek.SABADO.name}")
        Log.w("clases-9","ENUM SayOfWeek.SABADO should be ordinal ==> ${DayOfWek.SABADO.ordinal}")
        Log.w("clases-9","ENUM SayOfWeek.DOMINGO should be name ==> ${DayOfWek.DOMINGO.name}")
        Log.w("clases-9","ENUM SayOfWeek.DOMINGO should be ordinal ==> ${DayOfWek.DOMINGO.ordinal}")
    }

    fun showHolas(){
        hola()
        hola0()
        hola1()
        hola2()
        hola3()
        hola4()
        hola5()
        hola6()
        hola7()
    }
}

interface IPerson{
    var age: Int
    fun hello()
}

enum class DayOfWek{ LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO,DOMINGO }
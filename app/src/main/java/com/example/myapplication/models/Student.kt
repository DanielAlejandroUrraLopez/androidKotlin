package com.example.myapplication.models

import android.os.Parcel
import android.os.Parcelable

//parcel es un contendro para un mensaje
//puede ser usado para enviar un objecto cerialisado atraves de intent
// tiene mejor rendimiento para serializar
data class Student(var name: String, var lastName: String, var age: Int, var isDeveloper: Boolean = true): Parcelable {
    //leer en el mismo orden que edeclaramos las propiedades
    constructor(parcel: Parcel):
            this(
                parcel.readString()
                ,parcel.readString()
                ,parcel.readInt()
                ,parcel.readByte()!==0.toByte()
            )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        //tenemos que escribir los valores en el mismo orden en el que le hemos dado en el constructor
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if (isDeveloper) 1 else 0)
    }

    // describe el tipo de contenido del tipo parcelable
    // 0 siempre se usa  el otro valor es 1 o CONSTENT_FILE_DESCRIPTOR, ára tipos de objectos que implemnta en file desciprtor
    override fun describeContents() = 0

    companion object CREATOR: Parcelable.Creator<Student> {

        // esto creara el objeto desde el parcel llamando al constructor secundario
        override fun createFromParcel(parcel: Parcel) = Student(parcel)

        //esto ayudara a serializar arrays de objetos del mismo tipo que esta clase
        override fun newArray(size: Int) = arrayOfNulls<Student?>(size)

    }

}

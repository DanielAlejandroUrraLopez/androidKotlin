package com.example.myapplication.others

// para crear hacer una clse "estensible" o "heredable" tenemos que marcarlo como open.
//  en java es open por defecto y en kotlin es final por defecto , asi que  no puede ser extendida sin el uso de 'open'


open class AccessModifiers {

    // private      -- solo visible dentro de la cles
    // protected    -- solo visible dentro de la clase y despues de sus subclases (herencia)
    // public       -- visible desde dentro de la clse , de sus sublclases y desde fuera

    public val prop1 = "public by default"
    private val prop2 = "marker as private"
    protected val prop3 = "marker as protected"

    protected fun showCase(){
        val test = AccessModifiers()
        test.prop1
    }
}
class AccessModifiersChild : AccessModifiers(){
    private fun showCaseX(){
        super.showCase()
        prop1
        this.prop1
        // prop2 // por ser private no es accesible
        prop3
    }
}
class AnotherClass{
    private fun showCase(){
        val test = AccessModifiers()
        test.prop1
    }
}
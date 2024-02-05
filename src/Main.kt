/**
 * Clase base para representar a una persona.
 *
 * @property nombre Nombre de la persona.
 * @property edad Edad de la persona.
 *
 * @constructor Crea una instancia de [Persona] con el nombre y la edad proporcionados.
 */
open class Persona(val nombre:String, private var edad: Int){

    /**
     * Convierte la información de la persona a una cadena de texto.
     *
     * @return Cadena de texto que representa la información de la persona.
     */
    override fun toString(): String = "Nombre: $nombre, Edad: $edad"


    /**
     * Celebra el cumpleaños de la persona, incrementando su edad en uno.
     */
    fun celebrarcumple(){
        this.edad ++
        println("Felicidades $nombre, has cumplido $edad años")
    }

}

/**
 * Clase que representa a un empleado.
 *
 * @property nombre Nombre del empleado.
 * @property edad Edad del empleado.
 * @property salariobase Salario base del empleado (puede ser Double o Int).
 * @property porcentajeimpuestos Porcentaje de impuestos a aplicar al salario del empleado (por defecto es 10% y puede ser Double o Int).
 *
 * @constructor Crea una instancia de [Empleado] con el nombre, edad, salario base y porcentaje de impuestos proporcionados.
 */
open class Empleado(nombre:String, edad: Int,salariobase: Number, porcentajeimpuestos: Number = 10.0): Persona(nombre,edad){

    val salariobase = salariobase.toDouble()
    private val porcentajeimpuestos = porcentajeimpuestos.toDouble()

    /**
     * Calcula el salario del empleado después de aplicar los impuestos.
     *
     * @return Salario neto del empleado.
     */
    open fun calcularsalario():Double{
        return salariobase - (salariobase * (porcentajeimpuestos / 100))
    }

    /**
     * Convierte la información del empleado a una cadena de texto.
     *
     * @return Cadena de texto que representa la información del empleado.
     */
    override fun toString(): String {
        return "${super.toString()}, Salario: ${String.format("%.2f",calcularsalario())} "
    }

    /**
     * Simula la acción de trabajar.
     *
     * @return Mensaje indicando que el empleado está trabajando.
     */
    fun trabajar():String{
        return "$nombre, esta trabajando en la empresa"
    }

}


/**
 * Clase que representa a un Gerente, que es un tipo de empleado con características adicionales.
 *
 * @property bonus Monto del bonus para el Gerente (puede ser Double o Int).
 * @property exentoimpuestos Indica si el Gerente está exento de impuestos (por defecto es falso y puede ser Boolean).
 *
 * @constructor Crea una instancia de [Gerente] con el nombre, edad, salario base, porcentaje de impuestos, bonus y exención de impuestos proporcionados.
 */
class Gerente(nombre:String, edad: Int, salariobase: Number, bonus:Number, private var exentoimpuestos:Boolean = false, porcentajeimpuestos: Number = 33.99):Empleado(nombre, edad, salariobase, porcentajeimpuestos){

    private var bonus = bonus.toDouble()

    /**
     * Calcula el salario del Gerente, considerando el bonus y la exención de impuestos.
     *
     * @return Salario neto del Gerente.
     */
    override fun calcularsalario(): Double {
        return if (exentoimpuestos){
            salariobase + bonus
        }else{
            super.calcularsalario() + bonus
        }
    }

    /**
     * Convierte la información del Gerente a una cadena de texto.
     *
     * @return Cadena de texto que representa la información del Gerente.
     */
    override fun toString(): String {
        return "Gerente: ${super.toString()}, Bonus: $bonus, Exento a impuestos? $exentoimpuestos"
    }

    /**
     * Simula la acción de administrar.
     *
     * @return Mensaje indicando que el Gerente está administrando la empresa.
     */
    fun administrar():String{
        return "$nombre esta administrando la empresa "
    }
}

/**
 * Funcion principal del programa, donde creo
 */
fun main() {
    val pe1 = Persona("Fran",19)
    println(pe1)
    pe1.celebrarcumple()
    println()

    val em1 = Empleado("Andres",17,100)
    println(em1)
    em1.celebrarcumple()
    em1.trabajar()
    println()

    val ge1 = Gerente("Diego",52,2500,230,false)
    println(ge1)
    ge1.celebrarcumple()
    ge1.administrar()
    println()

    val ge2: Persona = Gerente("Diego",52,2500,230,false)
    ge2.celebrarcumple()

}

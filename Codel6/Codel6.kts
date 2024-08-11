//Pares y triples

// Partición de una lista de peces en agua dulce y salada
val twoLists = fish.partition { isFreshWater(it) }
println("freshwater: ${twoLists.first}") // Imprime la lista de peces de agua dulce
println("saltwater: ${twoLists.second}") // Imprime la lista de peces de agua salada

// Creación de un par (Pair) que asocia un equipo con su uso
val equipment = "fish net" to "catching fish"
println("${equipment.first} used for ${equipment.second}") // Imprime "fish net used for catching fish"

// Creación de un trío (Triple) con tres números
val numbers = Triple(6, 9, 42)
println(numbers.toString()) // Imprime la representación en cadena del trío "(6, 9, 42)"
println(numbers.toList())   // Convierte el trío en una lista y la imprime "[6, 9, 42]"

// Creación de un par donde la primera parte es un par
val equipment2 = ("fish net" to "catching fish") to "equipment"
println("${equipment2.first} is ${equipment2.second}\n") // Imprime "fish net, catching fish) is equipment"
println("${equipment2.first.second}") // Imprime "catching fish" (segunda parte del primer par)

// Desestructuración de un par
val (tool, use) = equipment
println("$tool is used for $use") // Imprime "fish net is used for catching fish"

// Desestructuración de un trío
val (n1, n2, n3) = numbers
println("$n1 $n2 $n3") // Imprime "6 9 42"


//Comprehend collections

// Crear una lista de números y sumar sus elementos
val list = listOf(1, 5, 3, 4)
println(list.sum()) // Imprime la suma de los elementos: 13

// Crear una lista de cadenas y tratar de sumar sus elementos
val list2 = listOf("a", "bbb", "cc")
println(list2.sum()) // Error: no se puede sumar directamente cadenas

// Sumar los elementos de la lista según la longitud de cada cadena usando sumBy
println(list2.sumBy { it.length }) // Imprime la suma de las longitudes: 6

// Usar un iterador para recorrer la lista e imprimir los elementos
for (s in list2.listIterator()) {
    println("$s ") // Imprime cada cadena seguida de un espacio: "a bbb cc"
}

// Crear un hash map que mapea síntomas a enfermedades de peces
val cures = hashMapOf("white spots" to "Ich", "red sores" to "hole disease")
println(cures.get("white spots")) // Imprime "Ich"
println(cures["red sores"]) // Imprime "hole disease"

// Intentar recuperar un valor con una clave que no existe
println(cures["scale loss"]) // Imprime "null"

// Usar getOrDefault para manejar claves inexistentes
println(cures.getOrDefault("bloating", "sorry, I don't know")) // Imprime "sorry, I don't know"

// Usar getOrElse para ejecutar código si la clave no existe
println(cures.getOrElse("bloating") { "No cure for this" }) // Imprime "No cure for this"

// Crear un mapa mutable para inventario y modificarlo
val inventory = mutableMapOf("fish net" to 1)
inventory.put("tank scrubber", 3) // Agrega 3 scrubbers
println(inventory.toString()) // Imprime "{fish net=1, tank scrubber=3}"
inventory.remove("fish net") // Remueve la red de pesca
println(inventory.toString()) // Imprime "{tank scrubber=3}"

//study constants

// Declaración de una constante numérica utilizando 'const val'
// La constante 'rocks' es evaluada en tiempo de compilación
const val rocks = 3

// Uso de 'val' para una asignación en tiempo de ejecución
val value1 = complexFunctionCall() // Esto es válido, ya que 'val' permite la asignación durante la ejecución

// Error: 'const val' no permite asignación en tiempo de ejecución
// const val CONSTANT1 = complexFunctionCall() // Esto no es permitido

// Uso de 'const val' dentro de un objeto singleton
object Constants {
    const val CONSTANT2 = "object constant" // Constante en un objeto singleton
}
val foo = Constants.CONSTANT2 // Accediendo a la constante del objeto singleton

// Creación de una clase con un objeto companion que contiene una constante
class MyClass {
    companion object {
        const val CONSTANT3 = "constant in companion" // Constante en un companion object
    }
}

//write extensions

// Definición de una función de extensión para la clase String que verifica si contiene espacios
fun String.hasSpaces(): Boolean {
    val found = this.find { it == ' ' } // Busca si hay un espacio en la cadena
    return found != null // Retorna true si se encuentra un espacio
}
println("Does it have spaces?".hasSpaces()) // Imprime "true"

// Versión simplificada de la función de extensión hasSpaces
fun String.hasSpaces() = find { it == ' ' } != null // Retorna true si se encuentra un espacio, en una sola expresión

// Clase AquariumPlant con una propiedad pública 'color' y una propiedad privada 'size'
class AquariumPlant(val color: String, private val size: Int)

// Función de extensión para AquariumPlant que verifica si el color es rojo
fun AquariumPlant.isRed() = color == "red" // OK: la función puede acceder a la propiedad pública 'color'

// Función de extensión para AquariumPlant que intenta acceder a la propiedad privada 'size' (provoca un error)
// fun AquariumPlant.isBig() = size > 50 // ERROR: 'size' es privada y no accesible en la extensión

// Clase derivada de AquariumPlant
open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

// Funciones de extensión para imprimir el tipo de planta
fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

// Uso de las funciones de impresión con diferentes tipos
val plant = GreenLeafyPlant(size = 10)
plant.print() // Imprime "GreenLeafyPlant"
val aquariumPlant: AquariumPlant = plant
aquariumPlant.print() // Imprime "AquariumPlant" debido a la resolución estática en tiempo de compilación

// Agregando una propiedad de extensión a AquariumPlant para verificar si el color es verde
val AquariumPlant.isGreen: Boolean
    get() = color == "green"
println(aquariumPlant.isGreen) // Imprime true si el color es "green"

// Función de extensión con un receptor nullable
fun AquariumPlant?.pull() {
    this?.apply { // Verifica si 'this' no es nulo
        println("removing $this") // Si no es nulo, imprime "removing [planta]"
    }
}
val plant: AquariumPlant? = null
plant.pull() // No imprime nada ya que 'plant' es nulo


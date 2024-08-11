package example.myapp

// Definición básica de la clase Aquarium
class Aquarium {
}

package example.myapp

// Clase Aquarium con propiedades inicializadas
class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100
}

// Función main que crea y construye un acuario
fun buildAquarium() {
    val myAquarium = Aquarium()
}

fun main() {
    buildAquarium()
}

// Método para imprimir el tamaño del acuario
fun printSize() {
    println("Width: $width cm " +
            "Length: $length cm " +
            "Height: $height cm ")
}

// Llama al método printSize() después de crear un acuario
fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
}

// Clase Aquarium con constructor primario y propiedades inicializadas
class Aquarium(length: Int = 100, width: Int = 20, height: Int = 40) {
    var length: Int = length
    var width: Int = width
    var height: Int = height
    ...
}

// Alternativa: Clase Aquarium con propiedades definidas en el constructor
class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    ...
}

// Ejemplos de diferentes acuarios con distintas dimensiones
fun buildAquarium() {
    val aquarium1 = Aquarium()
    aquarium1.printSize()

    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()

    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()

    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
}

// Inicializadores en la clase Aquarium
class Aquarium (var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    init {
        println("aquarium initializing")
    }
    init {
        println("Volume: ${width * length * height / 1000} l")
    }
}

// Constructor secundario que calcula la altura según el número de peces
constructor(numberOfFish: Int) : this() {
    val tank = numberOfFish * 2000 * 1.1
    height = (tank / (length * width)).toInt()
}

// Función para construir y mostrar las características del acuario
fun buildAquarium() {
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} l")
}

// Propiedad que calcula el volumen del acuario
val volume: Int
    get() = width * height * length / 1000

// Método para imprimir tamaño y volumen del acuario
fun printSize() {
    println("Width: $width cm " +
            "Length: $length cm " +
            "Height: $height cm ")
    println("Volume: $volume l")
}

// Método para crear un acuario, modificar su volumen y mostrarlo
fun buildAquarium() {
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    aquarium6.volume = 70
    aquarium6.printSize()
}

// Propiedad con un setter privado que ajusta la altura según el volumen
var volume: Int
    get() = width * height * length / 1000
    private set(value) {
        height = (value * 1000) / (width * length)
    }

// Clase Aquarium abierta para ser heredada
open class Aquarium (open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"

    open var water: Double = 0.0
        get() = volume * 0.9

    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        println("Volume: $volume l Water: $water l (${water/volume*100.0}% full)")
    }

    // Ejemplo de cómo construir y mostrar un acuario
    fun buildAquarium() {
        val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
        aquarium6.printSize()
    }

    // Subclase TowerTank que hereda de Aquarium y redefine el cálculo del volumen
    class TowerTank (override var height: Int, var diameter: Int):
        Aquarium(height = height, width = diameter, length = diameter)
    {
    }

    override var volume: Int
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }
}

// Clase Aquarium con propiedades sobreescritas en TowerTank
override var water = volume * 0.8
override val shape = "cylinder"

package example.myapp

import java.lang.Math.PI

... // Clase Aquarium existente

// Definición completa de TowerTank con propiedades sobrescritas
class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }

    override var water = volume * 0.8
    override val shape = "cylinder"
}

// Función para construir y mostrar un acuario y un TowerTank
fun buildAquarium() {
    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

// Clase abstracta y clases concretas para peces de acuario
abstract class AquariumFish {
    abstract val color: String
}

class Shark: AquariumFish() {
    override val color = "gray"
}

class Plecostomus: AquariumFish() {
    override val color = "gold"
}

// Función para crear y mostrar peces
fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    println("Plecostomus: ${pleco.color}")
}

fun main () {
    makeFish()
}

// Interfaz que define acciones de los peces
interface FishAction  {
    fun eat()
}

// Clases que implementan FishAction y definen su color y comportamiento
class Shark: AquariumFish(), FishAction {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: AquariumFish(), FishAction {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

// Función que crea peces, muestra su color y comportamiento
fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

// Interfaz FishColor que define una propiedad de color
interface FishColor {
    val color: String
}

// Clases que implementan FishAction y FishColor
class Plecostomus: FishAction, FishColor {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

class Shark: FishAction, FishColor {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

// Objeto que implementa FishColor con un color específico
object GoldColor : FishColor {
    override val color = "gold"
}

// Delegación de la implementación de FishColor en Plecostomus
class Plecostomus:  FishAction, FishColor by GoldColor {
    override fun eat() {
        println("eat algae")
    }
}

// Delegación de acciones y color en Plecostomus
class Plecostomus(fishColor: FishColor = GoldColor): FishAction,
    FishColor by fishColor {
    override fun eat() {
        println("eat algae")
    }
}

// Delegación de acciones de alimentación en Plecostomus
class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

class Plecostomus (fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

// Clase de datos básica con una propiedad
data class Decoration(val rocks: String) {
}

// Función que crea una decoración y la imprime
fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)
}

// Función que crea e imprime varias decoraciones
fun makeDecorations() {
    val decoration1 = DecorationParece que mi respuesta anterior fue cortada, así que continuaré desde donde se quedó:

    ```kotlin
    // Función que crea e imprime varias decoraciones
    fun makeDecorations() {
        val decoration1 = Decoration("granite")
        println(decoration1)

        val decoration2 = Decoration("slate")
        println(decoration2)

        val decoration3 = Decoration("slate")
        println(decoration3)
    }

// Destructuración de propiedades en la clase de datos Decoration
    val (rock, wood, diver) = decoration

    // Clase de datos con múltiples propiedades
    data class Decoration2(val rocks: String, val wood: String, val diver: String) {
    }

    fun makeDecorations() {
        val d5 = Decoration2("crystal", "wood", "diver")
        println(d5)

        // Asignar propiedades a variables individuales
        val (rock, wood, diver) = d5
        println(rock)
        println(wood)
        println(diver)
    }

// Ignorar una propiedad al destructurar
    val (rock, _, diver) = d5

    // Objeto singleton que implementa FishColor
    object GoldColor : FishColor {
        override val color = "gold"
    }

    // Enumeración que representa colores con valores RGB
    enum class Color(val rgb: Int) {
        RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
    }

    // Enumeración que representa direcciones con grados
    enum class Direction(val degrees: Int) {
        NORTH(0), SOUTH(180), EAST(90), WEST(270)
    }

    // Función que imprime información sobre una dirección
    fun main() {
        println(Direction.EAST.name)
        println(Direction.EAST.ordinal)
        println(Direction.EAST.degrees)
    }

    // Clase sellada y sus subclases para modelar animales marinos
    sealed class Seal
    class SeaLion : Seal()
    class Walrus : Seal()

    // Función que devuelve un String según el tipo de Seal
    fun matchSeal(seal: Seal): String {
        return when(seal) {
            is Walrus -> "walrus"
            is SeaLion -> "sea lion"
        }
    }

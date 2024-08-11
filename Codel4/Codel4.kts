package Codel4

class Codel4 {
}



/*Explorar la función main()*/

fun printHello() {
    println ("Hello World")
}

printHello()


fun main(args: Array<String>) {
    println("Hello, world!")
}

fun main(args: Array<String>) {
    println("Hello, ${args[0]}")
}

/* Agrega código y ejecuta tu programa*/

fun main(args: Array<String>) {
    println("Hello, world!")
}


/*Cambie el código para utilizar una plantilla de cadena*/
fun main(args: Array<String>) {
    println("Hello, ${args[0]}")
}


/*todo tiene un valor*/

// Will assign kotlin.Unit
val isUnit = println("This is an expression")
println(isUnit)


val temperature = 10
val isHot = if (temperature > 50) true else false
println(isHot)

val temperature = 10
val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
println(message)

/*Aprende más sobre las funciones*/
fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println ("Today is $day and the fish eat $food")
}

fun main(args: Array<String>) {
    feedTheFish()
}

fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}


fun fishFood (day : String) : String {
    var food = ""
    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
    }
    return food
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)

    println ("Today is $day and the fish eat $food")
}


fun fishFood (day : String) : String {
    val food : String
    when (day) {
        "Monday" -> food = "flakes"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Sunday" -> food = "plankton"
        else -> food = "nothing"
    }
    return food
}


fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}


import java.util.*    // required import

fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
}

fun main(args: Array<String>) {
    feedTheFish()
}


/*Crear un valor predeterminado para un parámetro*/

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

swim()   // uses default speed
swim("slow")   // positional argument
swim(speed="turtle-like")   // named parameter


fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" ->  true
        else -> false
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}


fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else  -> false
    }
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {
    ...


    /*Comenzar a utilizar los filtros*/

    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    fun main() {
        println( decorations.filter {it[0] == 'p'})
    }

    fun main() {
        val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

        // eager, creates a new list
        val eager = decorations.filter { it [0] == 'p' }
        println("eager: $eager")


        // lazy, will wait until asked to evaluate
        val filtered = decorations.asSequence().filter { it[0] == 'p' }
        println("filtered: $filtered")

        // force evaluation of the lazy list
        val newList = filtered.toList()
        println("new list: $newList")


        val lazyMap = decorations.asSequence().map {
            println("access: $it")
            it
        }


        val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
            println("access: $it")
            it
        }
        println("-----")
        println("filtered: ${lazyMap2.toList()}")

        /*Conozca las lambdas*/

        var dirtyLevel = 20
        val waterFilter = { dirty : Int -> dirty / 2}
        println(waterFilter(dirtyLevel))


        val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }

        /*Funciones lambas*/
        fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
            return operation(dirty)
        }
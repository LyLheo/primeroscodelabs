package codel3


*/operadores y tipos.*/
/*1+1
⇒ res8: kotlin.Int = 2

53-3
⇒ res9: kotlin.Int = 50

50/10
⇒ res10: kotlin.Int = 5

1.0/2.0
⇒ res11: kotlin.Double = 0.5

2.0*3.5
⇒ res12: kotlin.Double = 7.0*/


/*6*50
⇒ res13: kotlin.Int = 300

6.0*50.0
⇒ res14: kotlin.Double = 300.0

6.0*50
⇒ res15: kotlin.Double = 300.0

2.times(3)
⇒ res5: kotlin.Int = 6

3.5.plus(4)
⇒ res8: kotlin.Double = 7.5

2.4.div(2)
⇒ res9: kotlin.Double = 1.2*/




/*uso de tipos*/

val i: Int = 6
val b1 = i.to

val b1 = i.toByte()
println(b1)

val i4: Int = b2.toInt() // OK!
println(i4)
⇒ 1

val i5: String = b2.toString()
println(i5)
⇒ 1

val i6: Double = b2.toDouble()
println(i6)
⇒ 1.0





/*valor de los tipos de variables*/
var fish = 1
fish = 2
val aquarium = 1
aquarium = 2



/*  sobre las cadenas*/
var fish: Int = 12
var lakes: Double = 2.5

val numberOfFish = 5
val numberOfPlants = 12
"I have $numberOfFish fish" + " and $numberOfPlants plants"



/*Comparar condiciones y valores booleanos*/

val numberOfFish = 50
val numberOfPlants = 23
if (numberOfFish > numberOfPlants) {
    println("Good ratio!")
} else {
    println("Unhealthy ratio")
}


val fish = 50
if (fish in 1..100) {
    println(fish)
}

if (numberOfFish == 0) {
    println("Empty tank")
} else if (numberOfFish < 40) {
    println("Got fish!")
} else {
    println("That's a lot of fish!")
}


when (numberOfFish) {
    0  -> println("Empty tank")
    in 1..39 -> println("Got fish!")
    else -> println("That's a lot of fish!")
}

/*la nulidad*/

var rocks: Int = null
var marbles: Int? = null


var fishFoodTreats = 6
if (fishFoodTreats != null) {
    fishFoodTreats = fishFoodTreats.dec()
}


var fishFoodTreats = 6
fishFoodTreats = fishFoodTreats?.dec()

fishFoodTreats = fishFoodTreats?.dec() ?: 0

/*listas*/

val school = listOf("mackerel", "trout", "halibut")
println(school)

val myList = mutableListOf("tuna", "salmon", "shark")
myList.remove("shark")

val school = arrayOf("shark", "salmon", "minnow")
println(java.util.Arrays.toString(school))

val mix = arrayOf("fish", 2)

val numbers = intArrayOf(1,2,3)

val numbers = intArrayOf(1,2,3)
val numbers3 = intArrayOf(4,5,6)
val foo2 = numbers3 + numbers
println(foo2[5])


val numbers = intArrayOf(1, 2, 3)
val oceans = listOf("Atlantic", "Pacific")
val oddList = listOf(numbers, oceans, "salmon")
println(oddList)


val array = Array (5) { it * 2 }
println(java.util.Arrays.toString(array))


/*Hacer bucles*/

val school = arrayOf("shark", "salmon", "minnow")
for (element in school) {
    print(element + " ")
}


for ((index, element) in school.withIndex()) {
    println("Item at $index is $element\n")
}



for (i in 1..5) print(i)
⇒ 12345

for (i in 5 downTo 1) print(i)
⇒ 54321

for (i in 3..6 step 2) print(i)
⇒ 35

for (i in 'd'..'g') print (i)
⇒ defg



var bubbles = 0
while (bubbles < 50) {
    bubbles++
}
println("$bubbles bubbles in the water\n")

do {
    bubbles--
} while (bubbles > 50)
println("$bubbles bubbles in the water\n")

repeat(2) {
    println("A fish is swimming")
}
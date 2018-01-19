package decorator

fun main(args: Array<String>) {
    val beverage = Espresso()
    println(beverage.description + " $" + beverage.cost())
    val beverage2 = Whip(Mocha(Mocha(DarkRoast())))
    println(beverage2.description + " $" + beverage2.cost())
    val beverage3 = Whip(Mocha(Soy(HouseBlend())))
    println(beverage3.description + " $" + beverage3.cost())
}
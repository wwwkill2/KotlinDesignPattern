package adapter

fun main(args: Array<String>) {
    val duck = MallardDuck()
    val turkey = WildTurkey()
    val turkeyAdapter = TurkeyAdapter(turkey)
    println("The Turkey says...")
    turkey.gobble()
    turkey.fly()
    println("The Duck says...")
    testDuck(duck)
    println("The TurkeyAdapter says...")
    testDuck(turkeyAdapter)
}

fun testDuck(duck: Duck) {
    duck.quack()
    duck.fly()
}
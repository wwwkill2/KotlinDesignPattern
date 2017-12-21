package strategy

abstract class Duck {
    fun quack() = println("All ducks can quack.")

    fun swim() = println("All ducks can swim.")

    abstract fun display()
}

class MallardDuck : Duck() {
    override fun display() {
        println("I'm MallardDuck")
    }

}
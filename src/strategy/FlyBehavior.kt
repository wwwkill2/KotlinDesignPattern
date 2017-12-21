package strategy

interface FlyBehavior {
    fun fly()
}

class FlyWithWings : FlyBehavior {
    override fun fly() {
        println("I can fly")
    }
}

class FlyNoWay : FlyBehavior {
    override fun fly() {
        println("I cannot fly")
    }
}
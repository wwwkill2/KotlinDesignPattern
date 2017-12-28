package adapter

class TurkeyAdapter(val turkey: Turkey) : Duck {
    override fun quack() {
        turkey.gobble()
    }

    override fun fly() {
        for (i in 0 until 5) {
            turkey.fly()
        }
    }
}

class DuckAdapter(val duck: Duck) : Turkey {
    override fun gobble() {
        duck.quack()
    }

    override fun fly() {
        duck.fly()
    }

}
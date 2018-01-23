package adapter

import java.util.*

// 适配器模式：将一个类的接口，转换成客户期望的另一个接口。适配器让原本接口不兼容的类可以合作无间。

interface Duck {
    fun quack()
    fun fly()
}

class MallardDuck : Duck {
    override fun quack() = println("Quack")

    override fun fly() = println("I'm flying")
}

interface Turkey {
    fun gobble()
    fun fly()
}

class WildTurkey : Turkey {
    override fun gobble() = println("Gobble gobble")

    override fun fly() = println("I'm flying a short distance")
}

class TurkeyAdapter(val turkey: Turkey) : Duck {
    override fun quack() = turkey.gobble()

    override fun fly() {
        for (i in 0 until 5) {
            turkey.fly()
        }
    }
}

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

class EnumerationIterator(val enumeration: Enumeration<Int>) : Iterator<Int> {
    override fun hasNext() = enumeration.hasMoreElements()

    override fun next() = enumeration.nextElement()
}
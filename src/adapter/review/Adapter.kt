package adapter.review

/**
 * Author: WangJiaming
 * Time: 18/2/12
 * Description:
 */
// 复习适配器模式：适配器模式将一个类的接口，转换成客户期望的另一个接口。适配器让原本接口不兼容的类可以合作无间
// 外观模式：外观模式提供了一个统一的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用
interface Duck {
    fun quack()
    fun fly()
}

class MallardDuck : Duck {
    override fun quack() {
        println("Quack")
    }

    override fun fly() {
        println("I'm flying")
    }
}

interface Turkey {
    fun gobble()
    fun fly()
}

class WildTurkey : Turkey {
    override fun gobble() {
        println("Gobble gobble")
    }

    override fun fly() {
        println("I'm flying a short distance")
    }

}

class TurkeyAdapter(private val turkey: Turkey) : Duck {
    override fun quack() {
        turkey.gobble()
    }

    override fun fly() {
        for (i in 0..5) {
            turkey.fly()
        }
    }

}

fun testDuck(duck: Duck) {
    duck.quack()
    duck.fly()
}

fun main(args: Array<String>) {
    val duck = MallardDuck()
    val turkey = WildTurkey()
    val turkeyAdapter = TurkeyAdapter(turkey)

    println("The turkey says...")
    turkey.gobble()
    turkey.fly()

    println("The duck says...")
    testDuck(duck)

    println("The turkeyAdapter says...")
    testDuck(turkeyAdapter)
}

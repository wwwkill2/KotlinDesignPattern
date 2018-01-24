package template

// 模板方法：在一个方法中定义一个算法结构，而将一些步骤延迟到子类中。模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤
// 好莱坞原则：别调用我们，我们会调用你
// 工厂方法可以看做是特殊的模板方法

abstract class CaffeineBeverage {
    fun prepareRecipe() {
        boilWater()
        brew()
        pourInCup()
        if (customerWantsCondiments()) {
            addCondiments()
        }
    }

    private fun boilWater() = println("Boiling water")
    private fun pourInCup() = println("Pouring into cup")
    abstract fun brew()
    abstract fun addCondiments()
    open fun customerWantsCondiments() = true
}

class Coffee : CaffeineBeverage() {
    override fun brew() = println("Dripping coffee through filter")

    override fun addCondiments() = println("Adding sugar and milk")

}

class Tea : CaffeineBeverage() {
    override fun brew() = println("Steeping the tea")

    override fun addCondiments() = println("Adding lemon")

    override fun customerWantsCondiments() = false

}

fun main(args: Array<String>) {
    val tea = Tea()
    tea.prepareRecipe()
    val coffee = Coffee()
    coffee.prepareRecipe()
}
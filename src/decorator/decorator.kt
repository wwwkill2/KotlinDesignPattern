package decorator

// 装饰者模式：装饰者模式动态地将责任附加到对象上，若要扩展功能，装饰者提供了比继承更有弹性的替代方案

// 饮料的抽象类
abstract class Beverage(val description: String) {
    abstract fun cost(): Double
}

// 调料的抽象类
abstract class CondimentDecorator(description: String) : Beverage(description)

// 浓缩咖啡
class Espresso : Beverage("Espresso") {
    override fun cost(): Double = 1.99
}

class HouseBlend : Beverage("House Blend Coffee") {
    override fun cost(): Double = 0.89
}

class DarkRoast : Beverage("DarkRoast") {
    override fun cost(): Double = 0.99
}

// 摩卡调料
class Mocha(var beverage: Beverage) : CondimentDecorator(beverage.description + ",Mocha") {
    override fun cost(): Double = 0.2 + beverage.cost()
}

// 豆浆调料
class Soy(var beverage: Beverage) : CondimentDecorator(beverage.description + ",Soy") {
    override fun cost(): Double  = beverage.cost() + 0.15
}

// 奶泡调料
class Whip(var beverage: Beverage) : CondimentDecorator(beverage.description + ",Whip") {
    override fun cost(): Double  = 0.1 + beverage.cost()
}
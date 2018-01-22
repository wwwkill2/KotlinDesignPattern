package factory

// 简单工厂：荣获模式荣誉奖

// 工厂方法模式：定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。工厂方法让类把实例化推迟到子类
// 抽象工厂模式：提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类
// 依赖倒置原则：要依赖抽象，不要依赖具体类
// 引申说明：不能让高层组件，依赖低层组件。高层组件，就是由其他低层组件定义其行为的类
// 并且不管是高层组件还是低层组件，都应该依赖于抽象
abstract class Product

class ConcreteProduct : Product()

abstract class Factory {
    abstract fun createProduct(): Product
    fun otherMethod(): Product {
        val product = createProduct()
        // do something with the product
        return product
    }
}

class ConcreteFactory : Factory() {
    override fun createProduct(): Product {
        return ConcreteProduct()
    }
}


abstract class ProductA
abstract class ProductB
abstract class ProductC
abstract class ProductD

// 抽象工厂，生产对象家族
interface AbstractFactory {
    fun createProductA(): ProductA
    fun createProductB(): ProductB
    fun createProductC(): ProductC
    fun createProductD(): ProductD
}
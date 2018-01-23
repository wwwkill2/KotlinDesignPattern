package adapter

// 外观模式：提供了一个全新的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用。
// 最少知识原则：只和你的密友谈话
// 最少知识原则，告诉我们，在一个对象内，最好只调用 1.对象本身的方法 2.方法参数传进来的对象的方法 3.方法内部创建的对象的方法 4.对象内部组合对象的方法

interface Light {
    fun on()
    fun off()
}

interface Stereo {
    fun on()
    fun off()
    fun soundLoud()
    fun soundLow()
}

interface TV {
    fun on()
    fun off()
}

interface DVD {
    fun on()
    fun off()
}

// 建立外观
interface Facade {
    fun on()
    fun off()
}

// 实现具体外观
class ConcreteFacade(val light: Light, val stereo: Stereo, val tv: TV, val dvd: DVD) : Facade {
    override fun on() {
        light.on()
        stereo.on()
        stereo.soundLoud()
        tv.on()
        dvd.on()
    }

    override fun off() {
        light.off()
        stereo.soundLow()
        stereo.off()
        tv.off()
        dvd.off()
    }

}
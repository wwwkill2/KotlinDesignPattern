package observer

// 观察者模式的定义：
// 观察者模式定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新

// 主题接口
interface Subject {
    fun registerObserver(o: Observer)
    fun removeObserver(o: Observer)
    fun notifyObservers()
}

// 观察者接口
interface Observer {
    fun update(temperature: Float, humidity: Float, pressure: Float)
}

package observer

interface DisplayElement {
    fun display()
}

class ConcurrentDisplay(var subject: Subject) : Observer, DisplayElement {

    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    init {
        subject.registerObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        display()
    }

    override fun display() {
        println("目前状况：温度：$temperature，湿度：$humidity，气压：$pressure")
    }

}
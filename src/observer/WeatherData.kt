package observer

class WeatherData : Subject {

    var temperature: Float = 0.0f
    var humidity: Float = 0.0f
    var pressure: Float = 0.0f

    private val observers = arrayListOf<Observer>()

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        observers.remove(o)
    }

    override fun notifyObservers() {
        observers.forEach {
            it.update(temperature, humidity, pressure)
        }
    }

    fun measurementsChanged() {
        notifyObservers()
    }

}
package observer

fun main(args: Array<String>) {
    val weatherData = WeatherData()
    val concurrentDisplay = ConcurrentDisplay(weatherData)
    weatherData.temperature = 25f
    weatherData.humidity = 80f
    weatherData.pressure = 1f
    weatherData.measurementsChanged()
    weatherData.temperature = 26f
    weatherData.humidity = 90f
    weatherData.pressure = 1.2f
    weatherData.measurementsChanged()
}
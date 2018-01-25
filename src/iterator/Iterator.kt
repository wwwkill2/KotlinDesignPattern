package iterator

// 迭代器：


data class MenuItem(val name: String, val description: String, val vegetarian: Boolean, val price: Double)

// 煎饼屋菜单
class PencakeHouseMenu() {
    private val menuItems: ArrayList<MenuItem> = ArrayList()

    init {
        addItem("Pencake1", "Pencake1 description", true, 2.0)
        addItem("Pencake2", "Pencake2 description", false, 2.99)
        addItem("Pencake3", "Pencake3 description", true, 3.49)
        addItem("Pencake4", "Pencake4 description", true, 3.59)
    }

    fun createIterator() = PencakeHouseIterator(menuItems)

    private fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        val menuItem = MenuItem(name, description, vegetarian, price)
        menuItems.add(menuItem)
    }

}

// 午餐菜单
class DinnerMenu {
    companion object {
        val MAX_ITEMS = 6
    }

    private var numberOfItems = 0
    private val menuItems = linkedMapOf<String, MenuItem>()

    init {
        addItem("Dinner1", "Dinner1 description", true, 2.0)
        addItem("Dinner2", "Dinner2 description", false, 2.99)
        addItem("Dinner3", "Dinner3 description", true, 3.49)
        addItem("Dinner4", "Dinner4 description", true, 3.59)
    }

    fun createIterator() = DinnerMenuIterator(menuItems)

    private fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        if (numberOfItems >= MAX_ITEMS) {
            println("Sorry, menu is full")
        } else {
            val menuItem = MenuItem(name, description, vegetarian, price)
            menuItems.put(name, menuItem)
            numberOfItems++
        }
    }

}

// 服务员
class Alice {
    private val pencakeHouseMenu = PencakeHouseMenu()
    private val dinnerMenu = DinnerMenu()

    fun printMenu() {
        printIterator(pencakeHouseMenu.createIterator())
        printIterator(dinnerMenu.createIterator())
    }

    private fun printIterator(iterator: Iterator<MenuItem>) {
        while (iterator.hasNext()) {
            println(iterator.next())
        }
    }
}

interface Iterator<out T> {
    fun hasNext(): Boolean
    fun next(): T
}

class DinnerMenuIterator(val menuItems: LinkedHashMap<String, MenuItem>) : Iterator<MenuItem> {

    private var position = 0

    override fun hasNext() = position < menuItems.size

    override fun next(): MenuItem {
        var location = 0
        var menuItem: MenuItem? = null
        menuItems.forEach {
            if (location == position) {
                menuItem = it.value
                position++
                return menuItem!!
            } else {
                location++
            }
        }
        return menuItem!!
    }

}

class PencakeHouseIterator(val menuItems: ArrayList<MenuItem>) : Iterator<MenuItem> {

    private var position = 0

    override fun hasNext() = position < menuItems.size

    override fun next() = menuItems[position++]

}

fun main(args: Array<String>) {
    val alice = Alice()
    alice.printMenu()
}

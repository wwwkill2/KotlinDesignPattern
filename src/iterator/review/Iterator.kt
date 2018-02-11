package iterator.review

/**
 * Author: WangJiaming
 * Time: 18/2/11
 * Description: 迭代器模式提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示
 */

// 菜单项
data class MenuItem(val name: String, val description: String, val vegetarian: Boolean, val price: Double)

// 煎饼屋
class PencakeHouseMenu : Menu {
    private val menuItems = ArrayList<MenuItem>()

    init {
        addItem("Pencake1", "Pencake1 description", true, 2.0)
        addItem("Pencake2", "Pencake2 description", false, 2.99)
        addItem("Pencake3", "Pencake3 description", true, 3.49)
        addItem("Pencake4", "Pencake4 description", true, 3.59)
    }

    override fun createIterator(): Iterator<MenuItem> {
        return menuItems.iterator()
    }

    private fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        menuItems.add(MenuItem(name, description, vegetarian, price))
    }
}

// 餐厅
class DinnerMenu : Menu{
    companion object {
        val MAX_LENGTH = 6
    }

    private var numberOfItems = 0
    private val menuItems = arrayOfNulls<MenuItem>(MAX_LENGTH)

    init {
        addItem("Dinner1", "Dinner1 description", true, 2.0)
        addItem("Dinner2", "Dinner2 description", false, 2.99)
        addItem("Dinner3", "Dinner3 description", true, 3.49)
        addItem("Dinner4", "Dinner4 description", true, 3.59)
    }

    override fun createIterator(): Iterator<MenuItem> {
            return DinnerMenuIterator(menuItems)
    }

    private fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        if (numberOfItems >= MAX_LENGTH) {
            println("Menu is full")
        } else {
            menuItems[numberOfItems++] = MenuItem(name, description, vegetarian, price)
        }
    }
}

class DinnerMenuIterator(private val menuItems: Array<MenuItem?>) : Iterator<MenuItem> {
    var position = 0

    override fun hasNext(): Boolean {
        return position < menuItems.size && menuItems[position] != null
    }

    override fun next(): MenuItem {
        return menuItems[position++]!!
    }
}

interface Menu {
    fun createIterator(): Iterator<MenuItem>
}

// 女服务员
class Alice(private val pencakeHouseMenu: Menu, private val dinnerMenu: Menu) {

    private fun printIterator(iterator: Iterator<MenuItem>) {
        while (iterator.hasNext()) {
            println(iterator.next())
        }
    }

    fun printMenu() {
        printIterator(pencakeHouseMenu.createIterator())
        printIterator(dinnerMenu.createIterator())
    }
}

fun main(args: Array<String>) {
    val pencakeHouseMenu = PencakeHouseMenu()
    val dinnerMenu = DinnerMenu()
    val alice = Alice(pencakeHouseMenu, dinnerMenu)
    alice.printMenu()
}

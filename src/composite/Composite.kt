package composite

import java.util.*

/**
 * Author: WangJiaming
 * Time: 18/2/11
 * Description:
 */
// 组合模式：允许你将对象组合成树形结构来表现“整体\部分”的层次结构。组合能让客户以一致的方式处理个别对象以及对象组合

abstract class MenuComponent {
    open fun add(component: MenuComponent) {
        throw UnsupportedOperationException()
    }

    open fun remove(component: MenuComponent) {
        throw UnsupportedOperationException()
    }

    open fun getChildAt(index: Int): MenuComponent {
        throw UnsupportedOperationException()
    }

    open fun print() {
        throw UnsupportedOperationException()
    }

    abstract fun createIterator(): Iterator<MenuComponent?>
}

data class MenuItem(val name: String, val description: String, val vegetarian: Boolean, val price: Double) : MenuComponent() {
    override fun createIterator(): Iterator<MenuComponent?> {
        return NullIterator()
    }

    override fun print() = println(toString())
}

data class Menu(val name: String, val description: String) : MenuComponent() {
    override fun createIterator(): Iterator<MenuComponent?> {
        return CompositeIterator(menuComponents.iterator())
    }

    private val menuComponents = ArrayList<MenuComponent>()

    override fun add(component: MenuComponent) {
        menuComponents.add(component)
    }

    override fun remove(component: MenuComponent) {
        menuComponents.remove(component)
    }

    override fun getChildAt(index: Int) = menuComponents[index]

    override fun print() {
        println(name + "," + description)
        println("------------")
        val iterator = menuComponents.iterator()
        while (iterator.hasNext()) {
            iterator.next().print()
        }
    }
}

class CompositeIterator(iterator: Iterator<MenuComponent>) : Iterator<MenuComponent?> {
    private val stack = Stack<Iterator<MenuComponent?>>()

    init {
        stack.push(iterator)
    }

    override fun hasNext(): Boolean {
        return if (stack.isEmpty()) {
            false
        } else {
            val iterator = stack.peek()
            if (!iterator.hasNext()) {
                stack.pop()
                hasNext()
            } else {
                true
            }
        }
    }

    override fun next(): MenuComponent? {
        if (hasNext()) {
            val iterator = stack.peek()
            val component = iterator.next()
            if (component is Menu) {
                stack.push(component.createIterator())
            }
            return component
        } else {
            return null
        }
    }

}

class NullIterator : Iterator<MenuComponent?> {
    override fun hasNext(): Boolean {
        return false
    }

    override fun next(): MenuComponent? {
        return null
    }

}

class Alice(private val allMenus: MenuComponent) {
    fun printMenu() = allMenus.print()
    fun printVegetarianMenu() {
        val iterator = allMenus.createIterator()
        while (iterator.hasNext()) {
            val menuComponent = iterator.next()
            if (menuComponent is MenuItem && menuComponent.vegetarian) {
                menuComponent.print()
            }
        }
    }
}

fun main(args: Array<String>) {
    val pencakeHouseMenu = Menu("PENCAKE HOUSE MENU", "Breakfast")
    val dinnerMenu = Menu("DINNER MENU", "Lunch")
    val cafeMenu = Menu("CAFE MENU", "Dinner")
    val dessertMenu = Menu("DESSERT MENU", "Dessert of courses!")
    val allMenus = Menu("ALL MENUS", "All menus combined")
    allMenus.add(pencakeHouseMenu)
    allMenus.add(dinnerMenu)
    allMenus.add(cafeMenu)
    dinnerMenu.add(MenuItem("Dinner1", "Dinner1 description", false, 2.99))
    dessertMenu.add(MenuItem("Dessert1", "Dessert1 description", true, 1.49))
    dinnerMenu.add(dessertMenu)

    val alice = Alice(allMenus)
//    alice.printMenu()
    alice.printVegetarianMenu()

}


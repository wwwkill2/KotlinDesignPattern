package command

// 命令模式：将请求封装成对象，以便使用不同的请求、队列或日志来参数化其他对象。命令模式也支持可撤销的操作

// command
interface Command {
    fun execute()
    fun undo()
}

// receiver
class Light {
    fun on() = println("Light on!")
    fun off() = println("Light off!")
}

class GarageDoor {
    fun up() = println("Garage Door up!")
    fun down() = println("Garage Door down!")
}

// concrete command
class LightOnCommand(val light: Light) : Command {
    override fun execute() = light.on()
    override fun undo() = light.off()
}

class GarageDoorOpenCommand(val garageDoor: GarageDoor) : Command {
    override fun execute() = garageDoor.up()
    override fun undo() = garageDoor.down()
}

// invoker
class SimpleRemoteControl {
    var slot: Command? = null
    fun buttonWasPressed() = slot?.execute()
    fun undoWasPressed() = slot?.undo()
}

// client
fun main(args: Array<String>) {
    val remote = SimpleRemoteControl()
    val light = Light()
    val lightOnCommand = LightOnCommand(light)
    remote.slot = lightOnCommand
    remote.buttonWasPressed()
    remote.undoWasPressed()
    remote.slot = GarageDoorOpenCommand(GarageDoor())
    remote.buttonWasPressed()
    remote.undoWasPressed()
}
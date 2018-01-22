package singleton;


// 单件模式：确保一个类只有一个实例，并提供一个全局访问点
public class Singleton {

    private static Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}

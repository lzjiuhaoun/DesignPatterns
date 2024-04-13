package CreativeDesignPatterns.SingletonPattern;

/**
 * ClassName: SingletonPattern
 * Package: CreativeDesignPatterns.SingletonPattern
 * Description: 创建型对象模式-单例
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/13 19:50
 */
public class SingletonPattern {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        Singleton singleton3 = Singleton.getSingleton();
        System.out.println("singleton1=" + singleton1 + "\t" + "singleton2=" + singleton2 + "\t" + "singleton3=" + singleton3 + "\t"); //输出的对象地址都相同
    }
}

class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}

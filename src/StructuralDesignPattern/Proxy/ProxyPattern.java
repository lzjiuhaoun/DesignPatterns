package StructuralDesignPattern.Proxy;

/**
 * ClassName: ProxyPattern
 * Package: StructuralDesignPattern.Proxy
 * Description: 结构型对象设计模式-代理
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/14 18:38
 */
public class ProxyPattern {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject(); //具体的用户对象
        Proxy proxy = new Proxy(realSubject); //将用户对象传递给代理，由代理实现所有“购买”操作(代理本身的操作+用户的操作)
        proxy.buy();
    }
}

//客户端调用此接口（用户需要实现的操作）
interface Subject {
    void buy();
}

class RealSubject implements Subject {
    @Override
    public void buy() {
        System.out.println("付钱");
    }
}

//代理（代理需要实现的操作）
class Proxy implements Subject {
    protected RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    public void buy() {
        System.out.println("办理购买前的手续"); //代理执行的操作
        realSubject.buy(); //用户执行的操作
        System.out.println("办理购买后的手续"); //代理执行的操作
    }

}


package StructuralDesignPattern.AdapterPattern;

/**
 * ClassName: AdapterPattern
 * Package: StructuralDesignPattern.AdapterPattern
 * Description: 结构型对象模式-适配器
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/13 20:09
 */
public class AdapterPattern {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request(); //USB通过适配器执行特殊请求TYPE-C
    }
}

//USB
class Target {
    public void request() {
        System.out.println("普通请求 [USB数据线]~~");
    }
}

//适配器:使得USB数据线能实现TYPE-C数据线的功能
class Adapter extends Target {
    Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

//TYPE-C
class Adaptee {
    public void specificRequest() {
        System.out.println("特殊请求 [Type-C数据线]~~");
    }
}
package StructuralDesignPattern.Facade;

import java.util.Calendar;

/**
 * ClassName: FacadePattern
 * Package: StructuralDesignPattern.Facade
 * Description: 结构型对象设计模式-外观
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/14 13:00
 */
public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}

class Facade {
    SubSystemOne subSystemOne;
    SubSystemTwo subSystemTwo;
    SubSystemThree subSystemThree;

    public Facade() {
        subSystemOne = new SubSystemOne();
        subSystemTwo = new SubSystemTwo();
        subSystemThree = new SubSystemThree();
    }

    //将客户的请求代理给适当的子系统对象。
    public void methodA() {
        subSystemOne.methodOne(); //子系统对象：subSystemOne
    }

    public void methodB() {
        subSystemTwo.methodTwo();
    }

    public void methodC() {
        subSystemThree.methodThree();
    }
}

class SubSystemOne {
    public void methodOne() {
        System.out.println("执行子系统一 的功能~~~~~~~~~");
    }
}

class SubSystemTwo {
    public void methodTwo() {
        System.out.println("执行子系统二 的功能~~~~~~~~~");
    }
}

class SubSystemThree {
    public void methodThree() {
        System.out.println("执行子系统三 的功能~~~~~~~~~");
    }
}

package StructuralDesignPattern.Decorator;

/**
 * ClassName: DecoratorPattern
 * Package: StructuralDesignPattern.Decorator
 * Description: 结构型对象设计模式-装饰器
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/14 12:01
 */
public class DecoratorPattern {
    public static void main(String[] args) {
//        Person lzj = new Student("lzj");
//        lzj.Operation(); //执行原本的职责
//        System.out.println("----------------------------------------");
//        Person decoratorA = new DecoratorA(lzj);
//        decoratorA.Operation(); //执行原本的职责和装饰器A的职责
//        System.out.println("----------------------------------------");
        //法一： 上面这样写，是用 装饰器的职责+原本的职责，并不是我们想要的为原本的给一个对象添加额外的职责，可以修改为：
//        lzj = new DecoratorB(lzj); //踢足球
//        lzj = new DecoratorA(lzj); //写作业
//        lzj.Operation(); //{[(学习)踢足球]写作业} 先调用"写作业"操作，在"写作业"操作中会调用到“[(学习)踢足球]”操作
        //法二：对象链
//        Person lisi = new DecoratorB(new DecoratorA(new Student("lisi")));//学习、写作业、踢足球
        Person lisi = new DecoratorA(new DecoratorB(new Student("lisi")));//学习、踢足球、写作业
        lisi.Operation();

    }
}

//抽象类：人
abstract class Person {
    protected String name;

    public abstract void Operation(); //原本的职责
}

//具体类：学生
class Student extends Person {
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void Operation() {
        System.out.println(name + "的职责是：学习");
    }
}

//抽象类：装饰器，是Person的子类，且装饰器中有Person属性
abstract class Decorator extends Person {
    protected Person person;
}

//实现类：装饰器A
class DecoratorA extends Decorator {
    //装饰器A要初始化Person对象，这样才能在Person的基础上添加额外的职责
    public DecoratorA(Person person) {
        this.person = person;
    }

    //装饰器职责：执行Person本来的职责和额外的职责
    @Override
    public void Operation() {
        person.Operation();//原本的职责
        System.out.println(person.name + "装饰器A添加的职责：写作业");
    }
}

//实现类：装饰器B
class DecoratorB extends Decorator {
    //装饰器A要初始化Person对象，这样才能在Person的基础上添加额外的职责
    public DecoratorB(Person person) {
        this.person = person;
    }

    //装饰器职责：执行Person本来的职责和额外的职责
    @Override
    public void Operation() {
        person.Operation();//原本的职责
        System.out.println(person.name + "装饰器B添加的职责：踢足球");
    }
}
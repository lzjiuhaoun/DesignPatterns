package BehavioralDesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ObserverPattern
 * Package: BehavioralDesignPatterns.Observer
 * Description: 行为型对象设计模式-观察者
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/15 20:40
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subjectA = new ConcreteSubject("目标A");
        ConcreteObserver 张三 = new ConcreteObserver("张三", subjectA);
        ConcreteObserver 李四 = new ConcreteObserver("李四", subjectA);
        ConcreteObserver 王五 = new ConcreteObserver("王五", subjectA);
        subjectA.Detach(王五);
        subjectA.setState("2024年4月15日 更新了");
    }
}

//目标接口
interface Subject {
    void Attach(Observer observer); // 添加观察者

    void Detach(Observer observer); // 删除观察者

    void Notify(); // 状态改变后，通知所有观察者

    void setState(String state); // 设置状态（改变状态）

    String getState(); // 获取状态
}

//具体目标，UP主
class ConcreteSubject implements Subject {
    private List<Observer> observerList;
    private String state;
    private String name;

    public ConcreteSubject(String name) {
        state = "未更新";
        this.name = name;
        observerList = new ArrayList<>();
    }

    @Override
    public void Attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void Detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    @Override
    public void setState(String state) {
        System.out.println("目标的状态发生变化: 【" + this.state + "】 ----->>> 【" + state + "】");
        //目标更改状态，同时通知观察者更新状态
        this.state = state;
        Notify();
    }

    @Override
    public String getState() {
        return state;
    }
}

//观察者接口
interface Observer {
    //收到通知，更新观察者的状态
    void update();
}

//具体观察者，bilibili用户
class ConcreteObserver implements Observer {
    private String name;
    private Subject subject;
    private String state;

    public ConcreteObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject; //设置用户的目标
        subject.Attach(this); //在目标中添加此观察者
        state = subject.getState();//让观察者的状态和目标的状态初始值一致
    }

    @Override
    public void update() {
        System.out.println(name + "的状态发生变化: 【" + state + "】 ----->>> 【" + subject.getState() + "】");
        state = subject.getState(); //更新状态和目标的状态保持一致
    }
}
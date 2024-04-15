package BehavioralDesignPatterns.Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MementoPattern
 * Package: BehavioralDesignPatterns.Memento
 * Description: 行为型对象设计模式-备忘录
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/15 20:19
 */
public class MementoPattern {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker(); //管理者
        Originator originator = new Originator(); //原发器
        //添加第一次备份
        originator.setState("1024");
        Memento backup1 = originator.createMemento();
        caretaker.addMemento(backup1);
        //添加第二次备份
        originator.setState("2048");
        Memento backup2 = originator.createMemento();
        caretaker.addMemento(backup2);
        //添加第三次备份
        originator.setState("4096");
        Memento backup3 = originator.createMemento();
        caretaker.addMemento(backup3);
        //获取当前备份状态
        System.out.println(originator.getState());
        //展示所有备份
        caretaker.showMemento();
        //将备份恢复为第二次备份状态
        Memento memento1 = caretaker.getMemento(2);
        originator.setState(memento1.getState());
        System.out.println("根据第2次备份还原之后的状态为：" + originator.getState());
    }
}
// 原发器
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento memento) {
        state = memento.getState();
    }
}
// 备忘录
class Memento {
    private String state;

    public String getState() {
        return state;
    }

    public Memento(String state) {
        this.state = state;
    }
}
// 管理者
class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(int index) {
        // 判断参数是否合法
        if (index >= 1 && index <= mementoList.size()) {
            return mementoList.get(index - 1);
        }
        return null;
    }

    public void showMemento() {
        int cnt = 1;
        for (Memento memento : mementoList) {
            System.out.println("第" + cnt + "次备份，状态为：" + memento.getState());
            cnt++;
        }
    }
}

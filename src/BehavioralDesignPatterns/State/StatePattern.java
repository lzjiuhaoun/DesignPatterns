package BehavioralDesignPatterns.State;

import java.net.ConnectException;

/**
 * ClassName: StatePattern
 * Package: BehavioralDesignPatterns.State
 * Description: 行为型对象设计模式-状态
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/16 10:24
 */
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context(); //count=3
        context.Request(); //购买成功,count=2
        context.Request(); //购买成功,count=1
        context.Request(); //购买成功,count=0
        context.Request(); //购买失败，补货中~~~  --->>  补货成功，请重新购买,count=5
        context.Request(); //购买成功,count=4

    }
}

//抽象状态类
interface State {
    //不同的状态下，该方法的实现不同
    public void Handle(Context context);
}

//具体状态，售卖机有货的状态
class ConcreteStateA implements State {
    @Override
    public void Handle(Context context) {
        int count = context.getCount();
        if (count>=1) {
            context.setCount(count-1);
            System.out.println("购买成功,count="+context.getCount());
            if (context.getCount()==0) {
                context.setState(new ConcreteStateB());
            }
        }else {
            System.out.println("购买失败");
        }
    }
}

//具体状态，售卖机无货货的状态
class ConcreteStateB implements State {
    @Override
    public void Handle(Context context) {
        int count = context.getCount();
        if (count==0) {
            System.out.println("购买失败，补货中~~~");
            context.setCount(5);
            System.out.println("补货成功，请重新购买,count="+context.getCount());
            context.setState(new ConcreteStateA());
        }
    }
}

//售卖机
class Context {
    private State state;

    private int count;

    public Context() {
        state = new ConcreteStateA();
        count=3;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    //购买饮料
    public void Request(){
        state.Handle(this);
    }
}

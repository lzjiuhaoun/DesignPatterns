package BehavioralDesignPatterns.Mediator;

/**
 * ClassName: MediatorPattern
 * Package: BehavioralDesignPatterns.Mediator
 * Description:
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/15 19:47
 */
public class MediatorPattern {
    public static void main(String[] args) {
        ConcreteMediator concreteMediator = new ConcreteMediator();
        Colleague1 colleague1 = new Colleague1(concreteMediator);
        Colleague2 colleague2 = new Colleague2(concreteMediator);
        concreteMediator.setColleague1(colleague1);
        concreteMediator.setColleague2(colleague2);
        colleague1.senMessage("点了"); //同事1给中介发送消息，中介将消息发送给同事2
        colleague2.senMessage("好的");
    }
}
//抽象同事类
abstract class Colleague {
    protected Mediator mediator;
}

//具体同事1
class Colleague1 extends Colleague {
    //指定中介者
    public Colleague1(Mediator mediator) {
        this.mediator = mediator;
    }

    //发送消息
    public void senMessage(String message) {
        mediator.sendMessage(message, this);
    }

    //接收消息
    public void Notify(String message) {
        System.out.println("同事1接收到消息：" + message);
    }
}

//具体同事2
class Colleague2 extends Colleague {
    public Colleague2(Mediator mediator) {
        this.mediator = mediator;
    }

    public void senMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void Notify(String message) {
        System.out.println("同事2接收到消息：" + message);
    }
}


//抽象中介者
abstract class Mediator {
    //同事间进行通信的方法
    public abstract void sendMessage(String message, Colleague colleague);
}

//具体中介者
class ConcreteMediator extends Mediator {

    private Colleague1 colleague1;
    private Colleague2 colleague2;

    //指定同事，中介将消息发给该同事
    public void setColleague1(Colleague1 colleague1) {
        this.colleague1 = colleague1;
    }
    //指定同事，中介将消息发给该同事
    public void setColleague2(Colleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    /**
     * @param message   消息
     * @param colleague 消息发送房
     */
    @Override
    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleague1) {
            //将消息发送给同事2
            colleague2.Notify(message);
        } else {
            //将消息发送给同事1
            colleague2.Notify(message);
        }
    }
}
package BehavioralDesignPatterns.Command;

/**
 * ClassName: CommandPattern
 * Package: BehavioralDesignPatterns.Command
 * Description: 行为型对象设计模式-命令
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/15 16:26
 */
public class CommandPattern {
    public static void main(String[] args) {
        TV tv = new TV(); // 接收者 对象 电视机

        Command onCommand = new OnCommand(tv); // 命令对象 开机命令
        Command offCommand = new OffCommand(tv); // 命令对象 关机命令
        Invoker invoker = new Invoker(); //请求者

        invoker.setCommand(onCommand); // 给请求者设置 开机 命令
        invoker.call(); // 请求者去请求命令
        System.out.println("==============分割线===============");
        invoker.setCommand(offCommand); // 给请求者设置 关机命令
        invoker.call(); // 请求者去请求命令


    }
}

//请求者
class Invoker {
    private Command command;

    //设置请求者的命令
    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        command.Execute();
    }
}

//命令接口
interface Command {
    void Execute(); //执行命令
}

//开机命令
class OnCommand implements Command {

    private TV tv;

    public OnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OnAcation();
    }
}

//关机命令
class OffCommand implements Command {

    private TV tv;

    public OffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OffAcation();
    }
}

//接收者
class TV {
    //开机行为
    public void OnAcation() {
        System.out.println("电视开机了~~");
    }

    //关机行为
    public void OffAcation() {
        System.out.println("电视关机了~~");
    }
}

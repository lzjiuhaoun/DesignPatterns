package BehavioralDesignPatterns.TemplateMethod;

/**
 * ClassName: TemplateMethodPattern
 * Package: BehavioralDesignPatterns.TemplateMethod
 * Description: 行为型类设计模式-模板方法
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/16 12:12
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        Person student = new Student();
        Person teacher = new Teacher();
        //调用模板方法，其中student和teacher都执行模板方法和其特有的原语操作
        student.TemplateMethon();
        System.out.println("==========================================================");
        teacher.TemplateMethon();
    }
}
//抽象父类：人，将模板方法放入父类，将可变的原语操作放入子类
abstract class Person{
    //模板方法
    public void TemplateMethon(){
        System.out.println("模板方法:  上课 进入教室");
        Primitiveoperation1();
        System.out.println("模板方法:  下课 离开教室");
        Primitiveoperation2();
    }
    public abstract void Primitiveoperation1(); //原语操作1：上课(学生：听课；教师：讲课)
    public abstract void Primitiveoperation2(); //原语操作2：作业(学生：写作业；教师：批改作业)
}
class Teacher extends  Person{
    @Override
    public void Primitiveoperation1() {
        System.out.println("Teacher 上课，讲课，布置作业");
    }

    @Override
    public void Primitiveoperation2() {
        System.out.println("Teacher 批改作业，打分");
    }
}

class Student extends  Person{
    @Override
    public void Primitiveoperation1() {
        System.out.println("Student 上课，听课，做笔记");
    }

    @Override
    public void Primitiveoperation2() {
        System.out.println("Student 写作业，提交作业");
    }
}
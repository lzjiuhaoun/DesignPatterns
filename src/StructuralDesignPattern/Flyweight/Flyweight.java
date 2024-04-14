package StructuralDesignPattern.Flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ClassName: Flyweight
 * Package: StructuralDesignPattern.Flyweight
 * Description: 结构型对象设计模式-享元
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/14 17:53
 */
public class Flyweight {
    public static void main(String[] args) {
        Random random = new Random();
        String[] colors = {"red", "blue", "green", "whilte", "black"};
        //从colors中选择颜色，批量生成10个图案【可以发现，10个图案中，只new了5个对象，其余的对象都是用的已有的】
        ShapeFactory shapeFactory = new ShapeFactory();
        for (int i = 0; i < 10; i++) {
            Shape shape = shapeFactory.getShape(colors[random.nextInt(colors.length)]);
            shape.draw(random.nextInt(100), random.nextInt(100));
        }
    }
}

//图案工厂，生成图案
class ShapeFactory {
    private Map<String, Shape> map = new HashMap<String, Shape>();

    //选择颜色key,获取一个图案对象
    public Shape getShape(String key) {
        if (!map.containsKey(key)) { //图案对象不存在，则生成
            Shape shape = new Circle(key);
            map.put(key, shape);
            System.out.println("第一次生成该对象\tcreate color: " + key + " circle");
        }
        return map.get(key); //图案对象存在，直接返回
    }
}


//抽象类：图案
abstract class Shape {
    protected String color;

    public abstract void draw(int x, int y);
}

//具体类：圆，继承图案类
class Circle extends Shape {
    public Circle(String color) {
        this.color = color;
    }
    @Override
    public void draw(int x, int y) {
        System.out.println("draw a color: " + color + " circle x：" + x + " y：" + y);
    }
}

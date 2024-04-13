package StructuralDesignPattern.Bridge;

/**
 * ClassName: BridgePattern
 * Package: StructuralDesignPattern.Bridge
 * Description: 结构型对象设计模式-桥接
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/13 20:30
 */
public class BridgePattern {
    public static void main(String[] args) {
        Product product = new ProductA(); //此时具体产品是没有颜色的
        product.setName("产品A");
        Red red = new Red();
        product.setColor(red);//为具体产品设置颜色
        product.Operation(); //最终具体产品信息

        Product productA1 = new ProductA();
        productA1.setName("产品A1");
        Blue blue = new Blue();
        productA1.setColor(blue);
        productA1.Operation();
    }
}

//抽象产品
abstract class Product {
    private String name;
    protected Color color;//抽象颜色，在具体产品汇总调用具体颜色

    public void setName(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void Operation();
}

//具体产品
class ProductA extends Product {
    //打印具体产品信息
    @Override
    public void Operation() {
        color.OperationImpl(this.getname());
    }
}

//抽象颜色
interface Color {
    void OperationImpl(String name);
}

//具体颜色
class Red implements Color {
    @Override
    public void OperationImpl(String name) {
        System.out.println(name + "：红色");
    }
}

//具体颜色
class Blue implements Color {

    @Override
    public void OperationImpl(String name) {
        System.out.println(name + "：蓝色");
    }
}
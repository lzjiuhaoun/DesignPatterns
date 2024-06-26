package CreativeDesignPatterns.SimpleFactory;

/**
 * ClassName: SimpleFactory
 * Package: CreativeDesignPatterns
 * Description: 创建型设计模式-简单工厂模式
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/13 13:27
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Product productA = Factory.createProduct("A");
        productA.info();
        Product productB = Factory.createProduct("B");
        productB.info();
    }
}

class Factory {
    public static Product createProduct(String type) {
        Product product = null;
        switch (type) {
            case "A":
                product = new ProductA();
                break;
            case "B":
                product = new ProductB();
                break;
            default:
                System.out.println("没有" + type + "类型的产品!");
                return null;
        }
        return product;
    }
}

abstract class Product {
    public abstract void info();
}

class ProductA extends Product {
    @Override
    public void info() {
        System.out.println("产品的信息：A");
    }
}

class ProductB extends Product {

    @Override
    public void info() {
        System.out.println("产品的信息：B");
    }
}
package CreativeDesignPatterns.FactoryMethod;

/**
 * ClassName: FactoryMethod
 * Package: CreativeDesignPatterns
 * Description: 创建型设计模式-工厂方法
 *  工厂方法：使一个类的实例化延迟到其子类
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/13 13:44
 */
public class FactoryMethod {
    public static void main(String[] args) {
        //使一个类的实例化延迟到其子类
        Factory factoryA = new FactoryA();
        Product productA = factoryA.createProduct();
        productA.info();
        Factory factoryB = new FactoryB();
        Product productB = factoryB.createProduct();
        productB.info();

    }
}

interface Factory {
    public Product createProduct();
}

class FactoryA implements Factory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

class FactoryB implements Factory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}

interface Product {
    // public abstract void info();
    public abstract void info();
}

class ProductA implements Product {

    @Override
    public void info() {
        System.out.println("产品的信息：A");
    }
}

class ProductB implements Product {

    @Override
    public void info() {
        System.out.println("产品的信息：B");
    }
}


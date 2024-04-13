package CreativeDesignPatterns.AbstractFactory;

/**
 * ClassName: AbstractFactory
 * Package: CreativeDesignPatterns.AbstractFactory
 * Description: 创建型对象模式-抽象工厂
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/13 14:14
 */
public class AbstractFactory {
    public static void main(String[] args) {
        Factory1 factory1 = new Factory1();
        ProductA1 productA1 = factory1.createProductA();
        ProductB1 productB1 = factory1.createProductB();
        productA1.info();
        productB1.info();

        Factory2 factory2 = new Factory2();
        ProductA2 productA2 = factory2.createProductA();
        ProductB2 productB2 = factory2.createProductB();
        productA2.info();
        productB2.info();

    }
}

abstract class Factory {
    public abstract ProductA createProductA();

    public abstract ProductB createProductB();
}

class Factory1 extends Factory {

    @Override
    public ProductA1 createProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB1 createProductB() {
        return new ProductB1();
    }
}

class Factory2 extends Factory {

    @Override
    public ProductA2 createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB2 createProductB() {
        return new ProductB2();
    }
}

abstract class ProductA {
    public abstract void info();
}

abstract class ProductB {
    public abstract void info();
}

class ProductA1 extends ProductA {
    @Override
    public void info() {
        System.out.println("产品的信息：A1");
    }
}

class ProductA2 extends ProductA {
    @Override
    public void info() {
        System.out.println("产品的信息：A2");
    }
}

class ProductB1 extends ProductB {
    @Override
    public void info() {
        System.out.println("产品的信息：B1");
    }
}

class ProductB2 extends ProductB {
    @Override
    public void info() {
        System.out.println("产品的信息：B2");
    }
}


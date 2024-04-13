package CreativeDesignPatterns.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Builder
 * Package: CreativeDesignPatterns.Builder
 * Description: 创建型对象模式-生成器
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/13 18:20
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        //创建型对象模式-生成器:同样的构建过程可以创建不同的表示
        Builder builder1 = new Builder1();
        director.Construct(builder1);
        Product product1 = builder1.getResult();
        product1.show();

        Builder builder2 = new Builder2();
        director.Construct(builder2);
        Product product2 = builder2.getResult();
        product2.show();
    }
}
//服务员
class Director{
    public void Construct(Builder builder){
        builder.BuilderPart();
    }
}
//构建产品
abstract class Builder {
    public abstract void BuilderPart();

    public abstract Product getResult();
}

class Builder1 extends Builder {
    Product product = new Product();

    @Override
    public void BuilderPart() {
        product.add("A");
        product.add("B");
        product.add("C");
        product.add("D");
        product.add("E");
        product.add("F");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class Builder2 extends Builder {
    Product product = new Product();

    @Override
    public void BuilderPart() {
        product.add("A");
        product.add("B");
        product.add("C");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

//产品
class Product {
    List<String> parts = new ArrayList<String>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println("产品的组成：" + parts);
    }
}

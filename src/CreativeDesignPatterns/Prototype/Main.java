package CreativeDesignPatterns.Prototype;

/**
 * ClassName: Main
 * Package: CreativeDesignPatterns.Prototype
 * Description: 创建型对象模式-原型
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/13 19:31
 */
public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(2024, 5.25);
        Product product2 = (Product) product1.clone();
        System.out.println(product1.toString());
        System.out.println(product2.toString());

    }
}

interface Prototype {
    public abstract Object clone();
}

class Product implements Prototype {
    private int id;
    private double price;

    public Product() {
    }

    public Product(int id, double price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public Object clone() {
        Product object = new Product();
        object.id = this.id;
        object.price = this.price;
        return object;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
    //省略get、set方法、.....
}
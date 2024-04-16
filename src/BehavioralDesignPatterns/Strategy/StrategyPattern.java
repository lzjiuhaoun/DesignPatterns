package BehavioralDesignPatterns.Strategy;

/**
 * ClassName: StrategyPattern
 * Package: BehavioralDesignPatterns.Strategy
 * Description: 行为型对象设计模式-策略
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/16 11:03
 */
public class StrategyPattern {
    public static void main(String[] args) {

        OperationContext operationContext = new OperationContext(new AddStrategy());//加法策略
        operationContext.Operation(5, 4);

        OperationContext operationContext1 = new OperationContext(new SuntractionStrategy());//减法策略
        operationContext1.Operation(5, 4);

        OperationContext operationContext2 = new OperationContext(new MultiplyStrategy());//乘法策略
        operationContext2.Operation(5, 4);

    }
}

//环境，运算
class OperationContext {
    private Strategy strategy;

    public OperationContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void Operation(int a, int b) {
        strategy.TwoNumberOperation(a, b);
    }
}

//抽象策略
interface Strategy {
    //两个数运算的方法
    public void TwoNumberOperation(int a, int b);
}

//具体策略，加法
class AddStrategy implements Strategy {
    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println("a+b=" + (a + b));
    }
}

//具体策略，减法
class SuntractionStrategy implements Strategy {
    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println("a-b=" + (a - b));
    }
}

//具体策略，乘法
class MultiplyStrategy implements Strategy {
    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println("a*b=" + a * b);
    }
}
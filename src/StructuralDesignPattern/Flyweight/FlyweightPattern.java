package StructuralDesignPattern.Flyweight;

/**
 * ClassName: FlyweightPattern
 * Package: StructuralDesignPattern.Flyweight
 * Description: 结构型对象设计模式-享元
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/14 17:31
 */
public class FlyweightPattern {
    public static void main(String[] args) {
        PieceFactory pieceFactory = new PieceFactory();
        Piece piece = pieceFactory.getPiece(0);
        Piece piece1 = pieceFactory.getPiece(0);
        //两个白子用的都是同一个对象，只是在draw时，用的是棋子本身的方法。
        System.out.println(piece);
        System.out.println(piece1);
        System.out.println("=======================================================");
        piece.draw(5, 25);
        piece.draw(11, 17);

    }
}
//棋子工厂，确保工厂生成的黑子和白子都是同一个对象
class PieceFactory {
    Piece[] pieces = {new WhitePiece(), new BlackPiece()};
    public Piece getPiece(int key) {
        if (key == 0) {
            return pieces[0]; //白子
        } else {
            return pieces[1]; //黑子
        }
    }
}
//抽象类：棋子
abstract class Piece {
    protected String color;
    public abstract void draw(int x, int y);
}
//具体类，继承棋子类并设置棋子颜色
class WhitePiece extends Piece {
    public WhitePiece() {
        this.color = "White";
    }
    @Override
    public void draw(int x, int y) {
        System.out.println("draw a piece color:" + color + ",x:" + x + ",y:" + y);
    }
}
//具体类，继承棋子类并设置棋子颜色
class BlackPiece extends Piece {
    public BlackPiece() {
        this.color = "Black";
    }
    @Override
    public void draw(int x, int y) {
        System.out.println("draw a piece color:" + color + ",x:" + x + ",y:" + y);
    }
}
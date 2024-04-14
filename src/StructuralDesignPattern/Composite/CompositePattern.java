package StructuralDesignPattern.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: CompositePattern
 * Package: StructuralDesignPattern.Composite
 * Description: 结构型对象设计模式-组合
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/14 10:17
 */
public class CompositePattern {
    public static void main(String[] args) {
        //父类名 对象名 = new 子类();
        AbstractFile root = new Folder("root");
        AbstractFile folderA = new Folder("文件夹A");
        AbstractFile fileB = new File("文件B");
        AbstractFile folderC = new Folder("文件夹C");
        AbstractFile fileD = new File("文件D");
        //文件夹添加子组件(文件或文件夹)
        System.out.println(root.Add(folderA)); //true
        System.out.println(root.Add(fileB)); //true
        System.out.println(folderA.Add(folderC)); //true
        System.out.println(folderA.Add(fileD)); //true
        //打印所有文件夹
        printAbstractFile(root);
        //文件不能添加子组件(下面方法执行都为false)
        System.out.println(fileB.Add(folderA)); //false
        //System.out.println(fileB.Remove(folderA)); //false
        //打印所有文件
        printAbstractFile(fileB);
    }

    //打印组件(包括根节点和子组件)的方法
    public static void printAbstractFile(AbstractFile abstractFile) {
        abstractFile.printName(); //打印根节点
        List<AbstractFile> children = abstractFile.getChildren(); //获取根节点的子组件
        if (children == null) {
            return;
        }
        //循环打印子组件的各个结点
        for (AbstractFile child : children) {
            //存在当前节点时文件夹的情况，就要递归打印该节点
            printAbstractFile(child);
        }
    }

}

abstract class AbstractFile {
    protected String name;

    //打印当前文件夹/文件名
    public void printName() {
        System.out.println(name);
    }

    //添加子组件（文件执行该方法没有任何效果）
    public abstract boolean Add(AbstractFile abstractFile);

    //删除子组件(文件执行该方法没有任何效果)
    public abstract boolean Remove(AbstractFile abstractFile);

    //获取子组件（文件子组件为null）
    public abstract List<AbstractFile> getChildren();
}

class Folder extends AbstractFile {
    //文件夹中可以添加子组件（文件或文件夹）
    private List<AbstractFile> childrenList = new ArrayList<AbstractFile>(); //定义一个存放子组件的变量

    //打印当前文件夹名
    public Folder(String name) {
        this.name = name;
    }

    //文件夹添加文件或文件夹
    @Override
    public boolean Add(AbstractFile abstractFile) {
        return childrenList.add(abstractFile);
    }

    //文件夹删除文件或文件夹
    @Override
    public boolean Remove(AbstractFile abstractFile) {
        return childrenList.remove(abstractFile);
    }

    //获取文件夹的子组件
    @Override
    public List<AbstractFile> getChildren() {
        return childrenList;
    }
}

/**
 * 文件类之所以也要实现add和remove方法，是为了使得用户对单个对象 * 和组合对象的使用具有一致性。
 */
class File extends AbstractFile {
    //打印当前文件名
    public File(String name) {
        this.name = name;
    }

    //文件没有子组件，也就没有添加的功能，直接返回即可
    @Override
    public boolean Add(AbstractFile abstractFile) {
        return false;
    }

    //文件没有子组件,返回false
    @Override
    public boolean Remove(AbstractFile abstractFile) {
        return false;
    }

    //文件不没有子组件，返回null
    @Override
    public List<AbstractFile> getChildren() {
        return null;
    }
}

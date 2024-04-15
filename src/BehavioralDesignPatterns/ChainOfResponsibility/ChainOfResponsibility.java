package BehavioralDesignPatterns.ChainOfResponsibility;

/**
 * ClassName: ChainOfResponsibility
 * Package: BehavioralDesignPatterns
 * Description: 行为型对象设计模式-责任链
 *
 * @Author 工学院-liuzhaojun
 * @Create 2024/4/14 20:45
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler fuDaoYuan = new FuDaoYuan();
        Handler yuanZhang = new YuanZhang();
        Handler xiaoZhang = new XiaoZhang();
        fuDaoYuan.setNext(yuanZhang);
        yuanZhang.setNext(xiaoZhang);

        //执行过程：fuDaoYuan.HandRequest(29) ---辅导员无法审批>>> yuanZhang.HandRequest(29) ---校长无法审批>>>  xiaoZhang.HandRequest(29)
        fuDaoYuan.HandRequest(29);
    }
}

//处理者
abstract class Handler {
    protected Handler next; //继任者

    public void setNext(Handler next) {
        this.next = next;
    }

    //处理请求
    public abstract void HandRequest(int request);
}

//继任者1
class FuDaoYuan extends Handler {
    //辅导员审批 <7
    @Override
    public void HandRequest(int request) {
        if (request < 7) {
            System.out.println("辅导员审批通过");
        } else {
            if (next != null) {
                next.HandRequest(request); //辅导员这层不能解决，交由继任者解决
            } else {
                System.out.println("无法审批");
            }
        }
    }
}

//继任者2
class YuanZhang extends Handler {
    //校长审批 <14
    @Override
    public void HandRequest(int request) {
        if (request < 14) {
            System.out.println("院长审批通过");
        } else {
            if (next != null) {
                next.HandRequest(request); //院长这层不能解决，交由继任者解决
            } else {
                System.out.println("无法审批");
            }
        }
    }
}

class XiaoZhang extends Handler {
    //校长审批 <30
    @Override
    public void HandRequest(int request) {
        if (request < 30) {
            System.out.println("校长审批通过");
        } else {
            System.out.println("无法审批");
        }
    }
}
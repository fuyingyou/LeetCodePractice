package demo.juc;

public class Test1 {
    public static void main(String[] args) {
        Peach peach = new Peach();
        Monkey m1 = new Monkey("猴子1", peach);
        Monkey m2 = new Monkey("猴子2", peach);
        Monkey m3 = new Monkey("猴子3", peach);
        m1.start();
        m2.start();
        m3.start();
    }
}

class Peach {
    private int peachNum = 100;
    private int temp = 0;

    public int getPeachNum() {
        return peachNum;
    }
    //拿桃子的方法
    public synchronized void getPeach() {
        temp = peachNum;
        if (temp != 0) {
            if (temp % 2 == 0) {
                peachNum = temp / 2;
            } else {
                peachNum = temp - (temp + 1) / 2;
            }
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " 抢到了 " + (temp - peachNum) + " 个桃子，还剩 "
                        + peachNum + " 个桃子");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Monkey extends Thread {
    private Peach peach;

    public Monkey(String name, Peach peach) {
        super(name);
        this.peach = peach;
    }
    public void run() {
        super.run();

        while (peach.getPeachNum() != 0) {
            peach.getPeach();
        }
    }
}
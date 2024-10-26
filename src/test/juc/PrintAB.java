package test.juc;

public class PrintAB {

    private static final Object lock = new Object();
    private volatile static int state = 1;

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.print("a");
                    synchronized (lock) {
                        System.out.println("a");
                        if (state % 2 != 1) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            System.out.println("A");
                            state++;
                            lock.notifyAll();
                        }
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.print("b");
                    synchronized (lock) {
                        System.out.println("b");
                        if (state % 2 != 0) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            System.out.println("B");
                            state++;
                            lock.notifyAll();
                        }
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}

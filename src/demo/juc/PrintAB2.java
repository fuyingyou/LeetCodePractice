package demo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAB2 {

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition conditionA = lock.newCondition();
    public static Condition conditionB = lock.newCondition();

    public static int state = 0;

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    lock.lock();
                    try {
                        if (state % 2 != 0) {
                            conditionA.await();
                        }
                        System.out.print("A");
                        state++;
                        conditionB.signal();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    lock.lock();
                    try {
                        if (state % 2 != 1) {
                            conditionB.await();
                        }
                        System.out.print("B");
                        state++;
                        conditionA.signal();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}

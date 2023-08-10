package cn.cjj.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cjj
 * @date 2023/8/8 10:09
 * @description
 **/
public class ReentrantLockDemo {

    private final ReentrantLock LOCK = new ReentrantLock();
    private int count = 0;

    /**
     * 这里加一只是为了演示ReentrantLock，使用线程安全的原子类是更好的方法
     */
    public int add() {
        //或者使用tryLock()方法
        LOCK.lock();
        try {
            count++;
        } finally {
            LOCK.unlock();
        }
        return count;
    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLockDemo lockDemo = new ReentrantLockDemo();
        int countLimit = 20;

        //创建三个线程同时对count加1
        //这里创建线程只是为了演示，使用线程池创建线程是更好的方法
        new Thread(() -> {
            while (true) {
                int count = lockDemo.add();
                if (count > countLimit) {
                    return;
                }
                System.out.println(count);
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                int count = lockDemo.add();
                if (count > countLimit) {
                    return;
                }
                System.out.println(count);
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                int count = lockDemo.add();
                if (count > countLimit) {
                    return;
                }
                System.out.println(count);
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }).start();

        //暂停主线程10秒，等待子线程执行完毕
        TimeUnit.SECONDS.sleep(10);
    }

}

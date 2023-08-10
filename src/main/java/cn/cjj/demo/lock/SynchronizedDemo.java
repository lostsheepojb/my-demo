package cn.cjj.demo.lock;

/**
 * @author cjj
 * @date 2023/8/7 9:34
 * @description synchronized关键词的三种用法：修饰普通方法、修饰静态方法、同步块
 **/
public class SynchronizedDemo {

    /**
     * 第一种用法
     * synchronized修饰静态方法，此时锁是方法所在类的class对象
     */
    public static synchronized void staticMethod() {

    }

    /**
     * 第二种用法
     * synchronized修饰普通方法，此时锁是所在类的实例对象
     */
    public synchronized void normalMethod() {

    }

    /**
     * 第三种用法
     * synchronized修改块，此时锁是关键词后括号里的对象
     */
    public void synchronizedBlock() {
        synchronized (SynchronizedDemo.class) {

        }
    }

}

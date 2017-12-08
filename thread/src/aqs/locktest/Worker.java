package aqs.locktest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/5.
 */
public class Worker implements Runnable{
    private int num;
    private ReentrantLock lock ;

    public Worker(int num, ReentrantLock lock) {
        this.num = num;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(num+",kaishi");
        lock.lock();
        try {

            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        System.out.println(num+",结束");
    }
}

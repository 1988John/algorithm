package main.insertion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiangwang on 12/1/17.
 */
public class Test {

    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock(true);
        final Condition condition = reentrantLock.newCondition();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    System.out.println("我在等待一个命令："+this);
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("我收到命令了："+this);
                    reentrantLock.unlock();
                }
            }
        },"waitThread");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    reentrantLock.lock();
                    condition.signal();
                    reentrantLock.unlock();

                    reentrantLock.lock();
                    System.out.println("我拿到锁了");
                    Thread.sleep(3000);
//                    condition.signalAll();
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("一声令下！");
                    reentrantLock.unlock();
                }
            }
        },"signThread");
        thread2.start();

    }


}

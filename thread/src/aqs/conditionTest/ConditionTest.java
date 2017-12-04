package aqs.conditionTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/1.
 */
public class ConditionTest {
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock(true);
        final Condition condition = reentrantLock.newCondition();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    System.out.println("我要等一个信号："+this);
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("拿到一个信号："+this);
                    reentrantLock.unlock();
                }

            }
        },"waitThread1");

        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println("我拿到锁了");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    condition.signalAll();
                    System.out.println("我发出了一个信号！！");
                    reentrantLock.unlock();
                }


            }
        },"signThread");

        thread2.start();
    }
}

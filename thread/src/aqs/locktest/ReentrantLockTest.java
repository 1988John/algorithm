package aqs.locktest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/1.
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        //do something
        reentrantLock.unlock();
    }
}

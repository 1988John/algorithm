package aqs.locktest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/1.
 */
public class ReentrantLockTest {

    public static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {


        Worker worker1 = new Worker(1000*60*5,lock);

        Thread thread1 = new Thread(worker1,"A");
        thread1.start();
        for(int i=0;i<10;i++){
            Worker worker2 = new Worker(i*1000*30,lock);
            Thread thread2 = new Thread(worker2,"B"+i);
            thread2.start();
        }



        System.out.println("over");
    }
}

package aqs.countDownLatchTest;

import java.util.concurrent.locks.LockSupport;

/**
 * Description:
 * Created by jiangwang3 on 2017/11/30.
 */
public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("打游戏");
                LockSupport.park();
                System.out.println("出去");

                System.out.println(Thread.currentThread().interrupted());
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        thread.start();
        Thread.sleep(3000);
        System.out.println("朋友叫你出去");
//        LockSupport.unpark(thread);
        thread.interrupt();
    }
}

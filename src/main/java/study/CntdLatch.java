package study;

import java.util.concurrent.CountDownLatch;

public class CntdLatch {
    public static void main(String[] args) {
         final CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
            try {

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");

            latch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");

            latch.countDown();
        }).start();
        System.out.println("等待 2 个子线程执行完毕...");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2 个子线程已经执行完毕");
        System.out.println("继续执行主线程");
    }
}


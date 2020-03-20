package study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadPrintDemo2 {

    public static void main(String[] args) throws InterruptedException {
        ThreadPrintDemo2 demo2 = new ThreadPrintDemo2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(demo2::print1);
        executorService.execute(demo2::print2);
      // Thread.sleep(3000);
      //  executorService.shutdown();

    }

    public synchronized void print2() {

        for (int i = 1; i <= 100; i += 2) {
            System.out.println(i);
            this.notify();
            try {
                this.wait();
                Thread.sleep(10);// 防止打印速度过快导致混乱
            } catch (InterruptedException e) {


            }
        }
        this.notify();
    }

    public synchronized void print1() {

        for (int i = 0; i <= 100; i += 2) {
            System.out.println(i);
            this.notify();
            try {
                this.wait();
                Thread.sleep(10);// 防止打印速度过快导致混乱
            } catch (InterruptedException e) {
                // NO

            }
        }
        this.notify();
    }
}

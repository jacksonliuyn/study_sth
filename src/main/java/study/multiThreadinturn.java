package study;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Beauxie
 */
 class TestThread3 {

    // //通过JDK5中的锁来保证线程的访问的互斥
    private static Lock lock = new ReentrantLock();

    private  static int state = 0;// 用state来判断轮到谁执行

    private  static final int RUN_NUMBER=100;//表示循环的次数



    //A线程
    static class ThreadA {


        public void run() {
            for (int i = 0; i < RUN_NUMBER;i++) {
                lock.lock();//获取锁定
                if (state % 3 == 0) {
                    System.out.println("第"+(i+1)+"次:");
                    System.out.println("A");
                    state++;

                }
                lock.unlock();//释放锁定,不释放锁定，会被该线程一直保持
            }
        }
    }
    //B线程
    static class ThreadB {


        public void run() {
            for (int i = 0; i < RUN_NUMBER;) {
                lock.lock();
                if (state % 3 ==1) {
                    System.out.println("B");
                    state++;
                    i++;
                }
                lock.unlock();
            }
        }
    }
    //C线程
    static class ThreadC  {


        private void run() {
            for (int i = 0; i < RUN_NUMBER;) {
                lock.lock();
                if (state % 3 == 2) {
                    System.out.println("C");
                    state++;
                    i++;
                }
                lock.unlock();
            }
        }
    }
    public static void main (String[] args){

        ExecutorService  executorService = Executors.newCachedThreadPool();
        executorService.execute(new ThreadA()::run);
        executorService.execute(new ThreadB()::run);
        executorService.execute(new ThreadC()::run);


    }

}
class MultiThreadInTurn{
     private  int state = 0 ;
     private   void printA(){
         for(int i = 0; i< 100; ){
             synchronized(MultiThreadInTurn.class){

             if(state%3 == 0 ) {

                 System.out.println("num: " + (i+1)+ "ci");
                 System.out.println("A");
                 i++;
                 state++;
             }

             }
         }
     }
    private  void printB(){
        for(int i = 0; i< 100; ){
            synchronized(MultiThreadInTurn.class){
            if(state%3 == 1 ) {
                //System.out.println("num: " + i + 1 + "ci");
                System.out.println("B");
                i++;
                state++;
            }
                System.out.println("b: "+state);
        }
    }
     }
    private  void printC(){
        for(int i = 0; i< 100; ){
            synchronized(MultiThreadInTurn.class){

            if(state%3 == 2 ){
      //      System.out.println("num: "+i+1+"ci" );
            System.out.println("C");
            i++;
            state++;
            }
                System.out.println("c: "+state);
            }

        }
    }
     public static void  main(String[] args) {
         ExecutorService  executorService = Executors.newCachedThreadPool();
         MultiThreadInTurn turn = new MultiThreadInTurn();
         executorService.execute(turn::printA);
         executorService.execute(turn::printB);
         executorService.execute(turn::printC);
     }
}

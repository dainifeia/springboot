package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author xuzexiang
 * @Date: 2018-10-19 0019
 * @Description:
 */
public class TestThreadLocal2 {
    public static void main(String args[]) {
        RunnableDemo commonInstance = new RunnableDemo();

        Thread t1 = new Thread( commonInstance,"线程1");
        Thread t2 = new Thread( commonInstance,"线程2");
        Thread t3 = new Thread( commonInstance,"线程3");
        Thread t4 = new Thread( commonInstance,"线程4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // wait for threads to end
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch( Exception e) {
            System.out.println("Interrupted");
        }
    }

}
class RunnableDemo implements Runnable {
    int counter;
    ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<Integer>();

    public void run() {
        counter++;
        if(threadLocalCounter.get() != null){
            threadLocalCounter.set(threadLocalCounter.get().intValue() + 1);
        }else{
            threadLocalCounter.set(0);
        }
        System.out.println("Counter: " + counter);
        System.out.println("threadLocalCounter: " + threadLocalCounter.get());
    }
}

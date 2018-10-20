package countdounlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author xuzexiang
 * @Date: 2018-10-19 0019
 * @Description:    CountDownLatch相当于一种计数器  实现方式是 闭锁
 *      是一个同步的辅助类，允许一个或多个线程，等待其他一组线程完成操作，再继续执行
 */
public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
       CountDownLatch countDownLatch =  new CountDownLatch(5);
        CountDownLatchDemo downLatchDemo= new CountDownLatchDemo(countDownLatch);
        long startTime = System.currentTimeMillis();
        for(int i=0;i<5;i++){
            new Thread(downLatchDemo).start();
        }
        countDownLatch.await();//使当前线程在锁存器倒计数至零之前一直等待
        long endTime = System.currentTimeMillis();
        System.out.println("耗时："+(endTime-startTime));
    }
}

/**
 *输入500以内所有的偶数
 */
class CountDownLatchDemo implements Runnable{
    private CountDownLatch latch;

    public CountDownLatchDemo(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i=0;i<500;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
        latch.countDown();//递减锁存器的计数
    }
}

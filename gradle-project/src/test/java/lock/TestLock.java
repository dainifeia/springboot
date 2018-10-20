package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuzexiang
 * @Date: 2018-10-19 0019
 * @Description:    抢票例子
 */
public class TestLock {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        new Thread(t,"1号窗口").start();
        new Thread(t,"2号窗口").start();
        new Thread(t,"3号窗口").start();
    }
}

class Ticket implements Runnable{
    private int tick = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            lock.lock();    //加锁
            try {
                if(tick>0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出一张票，余票为" + --tick);
                }
                } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();  //释放锁
            }
        }
    }
}

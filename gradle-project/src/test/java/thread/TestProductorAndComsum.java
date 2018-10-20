package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuzexiang
 * @Date: 2018-10-19 0019
 * @Description:    生产者和消费者实例
 *      等待唤醒机制  ： 虚假唤醒
 */
public class TestProductorAndComsum {
    public static void main(String[] args) {
        Assistang assistang = new Assistang();
        Product product = new Product(assistang);
        Comsum comsum = new Comsum(assistang);
        new Thread(product,"生产者A").start();
        new Thread(comsum,"消费者A").start();
        new Thread(product,"生产者B").start();
        new Thread(comsum,"消费者B").start();

    }
}

//店员
class Assistang {
    private int product = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //进货
   public  void get(){
       lock.lock();
       try {
           while (product>=10){
               System.out.println("货品已满");
               try {
                   condition.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           System.out.println(Thread.currentThread().getName()+"生产了第:" + ++product );
           condition.signalAll();
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           lock.unlock();
       }
   }

    //卖货
    public  void sale(){
       lock.lock();
        try {
            while(product<=0){
                System.out.println("货品已卖完");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"消费:" + --product);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

//生产者
class Product implements  Runnable{
    private Assistang assistang;
    public Product(Assistang assistang){
        this.assistang = assistang;
    }
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            assistang.get();
        }
    }
}
//消费者
class Comsum implements  Runnable{
    private Assistang assistang;
    public Comsum(Assistang assistang){
        this.assistang = assistang;
    }
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            assistang.sale();
        }
    }
}
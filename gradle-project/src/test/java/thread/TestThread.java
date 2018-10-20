package thread;

import sun.misc.Unsafe;

import java.util.HashMap;

/**
 * @author xuzexiang
 * @Date: 2018-10-17 0017
 * @Description:
 */
public class TestThread extends Thread {
    public static int a = 0;
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Math.random()*1000);
        }


    }
private static void plus() {

    for (int i = 0; i < 10; i++) {
        new Thread() {
            public void run() {
                synchronized (Object.class) {
                    a++;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e)
                    { e.printStackTrace();
                    }
                    System.out.println("plus:" + Thread.currentThread().getName() + ": " + a);
                }
            }
        }.start();
    }
    }




    public static void main(String[] args) {
        plus();

       /* Thread t = new TestThread();
        t.start();*/
    }
}

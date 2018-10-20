package ThreadPool;

/**
 * @author xuzexiang
 * @Date: 2018-10-19 0019
 * @Description:
 */
public class TestThreadPool {
    public static void main(String[] args) {
        
    }
}
class ThreadPoolDemo implements Runnable{

    private int i=0;
    @Override
    public void run() {
        while (i<100){
            System.out.println(Thread.currentThread().getName()+":"+ i++ );
        }
    }
}

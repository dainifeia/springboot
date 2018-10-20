package FutureAndCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xuzexiang
 * @Date: 2018-10-19 0019
 * @Description:    FutureTask 也可实现闭锁
 */
public class TestCallable {
    public static void main(String[] args) {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> futureTask = new FutureTask<>(callableDemo);
        new Thread(futureTask).start();
        try {
            Integer sum= futureTask.get();
            System.out.println(sum);
            System.out.println("----");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class CallableDemo implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i=0;i<=100;i++){
            System.out.println(i);
            sum+=i;
        }
        return sum;
    }
}

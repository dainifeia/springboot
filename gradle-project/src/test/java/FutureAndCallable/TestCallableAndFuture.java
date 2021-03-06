package FutureAndCallable;

import java.util.concurrent.*;

/**
 * @author xuzexiang
 * @Date: 2018-10-19 0019
 * @Description:    Callable对象返回Future对象
 * Future对象可用于检查Callable的状态，然后线程完成后从Callable中检索结果。 它还提供超时功能
 */
public class TestCallableAndFuture {

    public static void main(final String[] arguments) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        System.out.println("Factorial Service called for 10!");
        Future<Long> result10 = executor.submit(new FactorialService(10));

        System.out.println("Factorial Service called for 20!");
        Future<Long> result20 = executor.submit(new FactorialService(20));

        Long factorial10 = result10.get();
        System.out.println("10! = " + factorial10);

        Long factorial20 = result20.get();
        System.out.println("20! = " + factorial20);

        executor.shutdown();
    }


    static class FactorialService implements Callable<Long> {
        private int number;
        public FactorialService(int number) {
            this.number = number;
        }

        @Override
        public Long call() throws Exception {
            return factorial();
        }

        private Long factorial() throws InterruptedException{
            long result = 1;
            while (number != 0) {
                result = number * result;
                number--;
                Thread.sleep(100);
            }
            return result;
        }
    }
}

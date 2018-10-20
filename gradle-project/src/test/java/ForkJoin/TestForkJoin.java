package ForkJoin;

import org.junit.Test;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author xuzexiang
 * @Date: 2018-10-19 0019
 * @Description:   fork-join框架允许在几个工作进程中断某个任务，然后等待结果组合它们。
 *                  它在很大程度上利用了多处理器机器的生产能力
 *      1.Fork是一个进程，其中任务将其分成可以并发执行的较小且独立的子任务。
 */
public class TestForkJoin {
    public static void main(String[] args) throws IOException {
        /*Long l = Runtime.getRuntime().freeMemory();//125553616
        l.toString().getBytes();
        System.out.println("可用内存"+l.intValue()/1024/1024);
        System.out.println("可用于Java虚拟机的处理器数量"+Runtime.getRuntime().availableProcessors());
        Runtime.getRuntime().exec("cmd");
        System.out.println("Java虚拟机将尝试使用的最大内存量"+Runtime.getRuntime().maxMemory());
        System.out.println("Java虚拟机中的内存总量"+Runtime.getRuntime().totalMemory());
        System.out.println(Long.SIZE);*/
/*

       // Long start = System.currentTimeMillis();
       Instant start = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoinDemo = new ForkJoinDemo(0L,1000000L);
        Long sum = forkJoinPool.invoke(forkJoinDemo);
        System.out.println(sum);
        Instant end = Instant.now();
        //long end = System.currentTimeMillis();
        System.out.println("耗时："+ Duration.between(start,end).toMillis());
*/


        //long start = System.currentTimeMillis();
        Instant start = Instant.now();
        Long sum = LongStream.rangeClosed(0L, 1000000L).parallel().sum();
        System.out.println(sum);
        Instant end = Instant.now();
       // long end = System.currentTimeMillis();
        System.out.println("耗费的时间为: " + Duration.between(start,end).toMillis());

    }

    @Test
    public void test1(){

    }
    @Test
    public void test2() {

    }
}

class ForkJoinDemo extends RecursiveTask<Long>{
    private long start;
    private long end;
    private static final long THRESHOLD = 10000L; // 临界值
    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;

        if (length <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinDemo left = new ForkJoinDemo(start, middle);
            left.fork(); // 拆分，并将该子任务压入线程队列
            ForkJoinDemo right = new ForkJoinDemo(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}


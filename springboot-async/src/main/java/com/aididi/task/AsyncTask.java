package com.aididi.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author xuzexiang
 * @Date: 2018/7/23 0023
 * @Description:
 */
@Component
public class AsyncTask {
    public static Random random = new Random();

    @Async
    public void task1() throws Exception {
        System.out.println("任务一开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end  = System.currentTimeMillis();
        System.out.println("任务一结束"+"耗时："+(end-start)+"毫秒");
    }
    @Async
    public void task2() throws Exception {
        System.out.println("任务二开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end  = System.currentTimeMillis();
        System.out.println("任务二结束"+"耗时："+(end-start)+"毫秒");
    }
    @Async
    public void task3() throws Exception {
        System.out.println("任务三开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end  = System.currentTimeMillis();
        System.out.println("任务三结束"+"耗时："+(end-start)+"毫秒");
    }

    @Async
    public Future<String> taskone() throws Exception {
        System.out.println("任务一开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end  = System.currentTimeMillis();
        System.out.println("任务一结束"+"耗时："+(end-start)+"毫秒");

        return new AsyncResult<>("任务一完成");
    }
    @Async
    public Future<String> tasktwo() throws Exception {
        System.out.println("任务二开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end  = System.currentTimeMillis();
        System.out.println("任务二结束"+"耗时："+(end-start)+"毫秒");
        return new AsyncResult<>("任务二完成");
    }
    @Async
    public Future<String> taskthree() throws Exception {
        System.out.println("任务三开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end  = System.currentTimeMillis();
        System.out.println("任务三结束"+"耗时："+(end-start)+"毫秒");
        return new AsyncResult<>("任务三完成");
    }

}

package com.aididi.task;


import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author xuzexiang
 * @Date: 2018/7/23 0023
 * @Description:同步演示
 */
@Component
public class SyncTask {

        public static Random random = new Random();

    public void task1() throws Exception {
        System.out.println("任务一开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end  = System.currentTimeMillis();
        System.out.println("任务一结束"+"耗时："+(end-start)+"毫秒");
    }
    public void task2() throws Exception {
        System.out.println("任务二开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end  = System.currentTimeMillis();
        System.out.println("任务二结束"+"耗时："+(end-start)+"毫秒");
    }
    public void task3() throws Exception {
        System.out.println("任务三开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end  = System.currentTimeMillis();
        System.out.println("任务三结束"+"耗时："+(end-start)+"毫秒");
    }


}

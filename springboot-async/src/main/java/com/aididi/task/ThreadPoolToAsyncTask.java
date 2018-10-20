package com.aididi.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author xuzexiang
 * @Date: 2018/7/23 0023
 * @Description:
 */
@Slf4j
@Component
public class ThreadPoolToAsyncTask {
    @Autowired
    private  StringRedisTemplate stringRedisTemplate ;

    public static Random random = new Random();

    @Async("taskExecutor")
    public void task1() throws Exception {
        log.info("任务一开始执行");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("任务一结束，耗时："+(end-start)+"毫秒");
    }

    @Async("taskExecutor")
    public void task2() throws Exception {
        log.info("任务二开始执行");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("任务二结束，耗时："+(end-start)+"毫秒");
    }

    @Async("taskExecutor")
    public void task3() throws Exception {
        log.info("任务三开始执行");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("任务三结束，耗时："+(end-start)+"毫秒");
    }

    @Async("taskScheduler")
    public void shutdownTask1() throws Exception {
        log.info("shutdown任务一开始执行");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("shutdown任务一结束，耗时："+(end-start)+"毫秒");
    }

    @Async("taskScheduler")
    public void shutdownTask2() throws Exception {
        log.info("shutdown任务二开始执行");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("shutdown任务二结束，耗时："+(end-start)+"毫秒");
    }

    @Async("taskScheduler")
    public void shutdownTask3() throws Exception {
        log.info("shutdown任务三开始执行");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("shutdown任务三结束，耗时："+(end-start)+"毫秒");
    }
}

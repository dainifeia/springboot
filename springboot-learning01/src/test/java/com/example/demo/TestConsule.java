package com.example.demo;

import com.aididi.Utils.DateUtil;
import com.aididi.Utils.TrafficLamp;
import com.aididi.vo.User;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * @Auther: xuzexiang
 * @Date: 2018/6/26 0026 10:28
 * @Description:
 */
public class TestConsule {
    @Test
    public void test01(){

        ExecutorService service = Executors.newCachedThreadPool(); // 创建一个线程池
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                try {
                    System.out.println(Thread.currentThread().getName()+":"+ DateUtil.parse("2017-06-24 06:02:20"));
                    Thread.sleep(30000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            };
            service.execute(runnable);// 为线程池添加任务
        }
    }

    @Test
    public void testlambda(){
        ExecutorService service = Executors.newCachedThreadPool(); // 创建一个线程池
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+":"+DateUtil.parse("2017-06-24 06:02:20"));
                        Thread.sleep(30000);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            };
            service.execute(runnable);// 为线程池添加任务
        }
    }
}

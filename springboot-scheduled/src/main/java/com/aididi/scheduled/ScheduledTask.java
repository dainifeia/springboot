package com.aididi.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xuzexiang
 * @Date: 2018/7/9 0009
 * @Description:   @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
 *                  @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
 *                  @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
 *                  @Scheduled(cron="0 10 * * * *") ：通过cron表达式定义规则
 */
@Component
public class ScheduledTask {
    /**
     * 功能描述:
     * @param: []
     * @return: void
     * @auther: xuzexiang
     * @date: 2018/7/9 0009 下午 5:10
     * @Description: fixedRate=1000 上一个调用开始后再次调用的延时（不用等待上一次调用完成）
     */
    @Scheduled(fixedRate = 1000)
    public void cron1() throws Exception{

        Thread.sleep(2000);
        System.out.println("执行cron1的时间：" + new Date(System.currentTimeMillis()));
    }

    /**
     * 功能描述:
     * @param:
     * @return:
     * @auther: xuzexiang
     * @date: 2018/7/9 0009 下午 5:12
     * @Description: fixedDelay 该属性后会等到方法执行完成后延迟配置的时间再次执行该方法
     */
    @Scheduled(fixedDelay = 1000)
    public void cron2() throws Exception{

        Thread.sleep(2000);
        System.out.println("执行cron2的时间：" + new Date(System.currentTimeMillis()));
    }

    /**
     * 功能描述:
     * @param:
     * @return:
     * @auther: xuzexiang
     * @date: 2018/7/9 0009 下午 5:16
     * @Description:   initialDelay需要配合fixedDelay或者fixedRate来使用
     *                  该属性的作用是第一次执行延迟时间，只是做延迟的设定，并不会控制其他逻辑，如配置所示，程序启动成功后第一秒执行定时任务，而是在内部延迟一秒后在执行定时任务
     */
    @Scheduled(initialDelay = 1000*10 ,fixedDelay = 2000)
    public void cron3() throws Exception{
        System.out.println("执行cron3的时间：" + new Date(System.currentTimeMillis()));
    }
}

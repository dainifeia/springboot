package com.aididi.pool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;

/**
 * @author xuzexiang
 * @Date: 2018/7/23 0023
 * @Description:
 */
@Configuration
public class TaskSchedulerConfig {

    @Bean(name = "taskScheduler")
    public Executor taskScheduler(){
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(20);
        scheduler.setThreadNamePrefix("schedulertask--");
        //设置线程池关闭时先等待所有任务先完成在销毁其它的bean，这样异步任务的销毁就会先于redis线程的销毁
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        //设置线程池中任务的等待时间，如果超过设置的时间还未销毁就强制销毁，以确保最后任务能够关闭，而不是阻塞住
        scheduler.setAwaitTerminationSeconds(60);
        return scheduler;
    }
}

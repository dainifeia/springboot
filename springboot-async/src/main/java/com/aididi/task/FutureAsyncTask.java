package com.aididi.task;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Component
public class FutureAsyncTask {
    public static Random random = new Random();
    @Async("taskExecutor")
    public Future<String> futureTask() throws Exception {
       long sleep =  random.nextInt(10000);
       log.info("任务开始，耗时："+sleep+"毫秒");
       Thread.sleep(sleep);
       log.info("任务完成");
       return new AsyncResult<>("test");
    }

}

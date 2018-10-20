package com.aididi;

import com.aididi.task.AsyncTask;
import com.aididi.task.FutureAsyncTask;
import com.aididi.task.SyncTask;
import com.aididi.task.ThreadPoolToAsyncTask;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
@Slf4j
public class SpringbootAsyncApplicationTests {

	@Autowired
	private SyncTask syncTask;

	@Autowired
	private AsyncTask asyncTask;

    @Autowired
	private ThreadPoolToAsyncTask poolToAsyncTask;

    @Autowired
    private FutureAsyncTask futureAsyncTask;

	@Test
	public void contextLoads() {
	}

	@Test
	public void syncTask() throws Exception {
		syncTask.task1();
		syncTask.task2();
		syncTask.task3();
	}

	@Test
	public void asyncTask() throws Exception {
		asyncTask.task1();
		asyncTask.task2();
		asyncTask.task3();
	}

	@Test
	public void asyncFutureTask() throws Exception {
		long start = System.currentTimeMillis();

		Future<String> task1 = asyncTask.taskone();
		Future<String> task2 = asyncTask.tasktwo();
		Future<String> task3 =  asyncTask.taskthree();
		while (true){
			if(task1.isDone() && task2.isDone() && task3.isDone()){
				// 三个任务都调用完成，退出循环等待
				break;
			}
		}
		long end  = System.currentTimeMillis();
		System.out.println("任务全部完成，总耗时："+(end-start)+"毫秒");
	}

	@Test
    public void threadPoolAsyncTask() throws Exception {
        poolToAsyncTask.task1();
        poolToAsyncTask.task2();
        poolToAsyncTask.task3();
        Thread.currentThread().join();
    }

    @Test
    @SneakyThrows
    public void shutDownTask(){
	    for (int i=0;i<10000;i++){
            poolToAsyncTask.shutdownTask1();
            poolToAsyncTask.shutdownTask2();
            poolToAsyncTask.shutdownTask3();
            if(i == 9999){
                System.exit(0);
            }

        }
    }

    @Test
    public void furureResultTask() throws Exception {
        Future<String> futureResult = futureAsyncTask.futureTask();
        String result = futureResult.get(5, TimeUnit.SECONDS);
        log.info("返回信息"+result);
    }
}

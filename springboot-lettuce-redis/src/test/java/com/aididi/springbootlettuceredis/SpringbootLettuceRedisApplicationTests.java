package com.aididi.springbootlettuceredis;

import com.aididi.springbootlettuceredis.domain.User;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLettuceRedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String,Serializable> redisTemplate;

	@Test
		public void contextLoads() {
		List<String> list = new ArrayList<String>();
		list.stream();

		//测试线程安全
		LocalTime time1 = LocalTime.now();

		ExecutorService executorService = Executors.newFixedThreadPool(1000);
		IntStream.range(0,1000).forEach(i ->executorService.execute(()->stringRedisTemplate.opsForValue().increment("kk",1) ));
		LocalTime time2 = LocalTime.now();
		Duration duration = Duration.between(time1, time2);
		log.info("消耗时间"+duration.toMillis());
		stringRedisTemplate.opsForValue().set("k1","v1");
		final String k1 = stringRedisTemplate.opsForValue().get("k1");
		log.info("字符缓存结果"+k1);
		// TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
		String key = "mapper:user:1";
		redisTemplate.opsForValue().set(key,new User(1L,"admin","123"));
		final User user = (User) redisTemplate.opsForValue().get(key);
		log.info("对象缓存结果"+user);
	}

}

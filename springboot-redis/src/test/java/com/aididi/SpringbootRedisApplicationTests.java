package com.aididi;

import com.aididi.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;

	@Test
	public void testRedisCache() {
		stringRedisTemplate.opsForValue().set("user","qweasd");
		Assert.assertEquals("qweasd",stringRedisTemplate.opsForValue().get("user"));
	}

    @Test
    public void test1(){

    }

	@Test
	public void testRedis() throws Exception {
        User user = new User("123@qq.com","asan","123","admin","123");
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set("com.aididi",user);
        //设置key过期时间为20秒
        operations.set("com.aididi.a",user,20, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //判断是否有这个key
        boolean flg =  redisTemplate.hasKey("com.aididi.a");
        if(flg){
            System.out.println("exists is true");
        }else {
            System.out.println("exists is false ");
        }
  }

}

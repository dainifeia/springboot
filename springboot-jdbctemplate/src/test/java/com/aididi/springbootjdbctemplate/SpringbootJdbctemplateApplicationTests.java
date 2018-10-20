package com.aididi.springbootjdbctemplate;

import com.aididi.springbootjdbctemplate.domain.User;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJdbctemplateApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log4j2
public class SpringbootJdbctemplateApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testaddUser() throws Exception{
		testRestTemplate.postForEntity("http://localhost:"+port+"/users",new User("admin","123456"),Integer.class);
		log.info("添加用户成功\n");
		ResponseEntity<List<User>> responseEntity =testRestTemplate.exchange("http://localhost:"+port+"/users/all", HttpMethod.GET,null,
				new ParameterizedTypeReference<List<User>>(){});
		final List<User> list = responseEntity.getBody();
		log.info("查询所有数据");
		Long userId = list.get(0).getId();
		testRestTemplate.getForEntity("http://localhost:"+port+"/users/{id}",User.class,userId);
		log.info("查询一条数据"+userId);
		testRestTemplate.put("http://localhost:"+port+"/users/{id}",new User("abc","123"),userId);
		log.info("修改"+userId+"数据成功");
		testRestTemplate.delete("http://localhost:"+port+"/users/{id}",userId);
		log.info("删除"+userId+"成功");
	}

	private static int paCalcFlag = 0; // 工资计算结果是否在导出的标示

	@Test
	public void test2(){
		int flag = paCalcFlag;

		paCalcFlag = paCalcFlag == 0 ? 1 : paCalcFlag;

		log.info("值："+paCalcFlag);
		log.info("工资计算结果导出的标示: " + flag);
	}

}

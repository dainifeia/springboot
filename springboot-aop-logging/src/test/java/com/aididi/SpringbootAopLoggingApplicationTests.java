package com.aididi;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class SpringbootAopLoggingApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testaop(){
		log.info("info日志");
		log.debug("debug日志");
		log.error("error日志");
	}

}

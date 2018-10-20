package com.aididi;

import com.aididi.Sender.MailSender;
import com.aididi.enums.MailSenderEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMailApplicationTests {

	@Test
	public void testSendMail() throws Exception {
		new MailSender().title("测试邮件发送").content("随便发").contentType(MailSenderEnum.TEXT).targets(new ArrayList<String>(){{
			add("15711337827@163.com");
		}}).send();

	}



}

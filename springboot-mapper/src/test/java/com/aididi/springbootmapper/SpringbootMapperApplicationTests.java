package com.aididi.springbootmapper;

import com.aididi.springbootmapper.domain.User;
import com.aididi.springbootmapper.mapper.UserMapper;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMapperApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Test
	public void contextLoads() {
	}


	@Test
	public void test1(){
		final User user1 = new User("u1", "p1");
		final User user2 = new User("u1", "p2");
		final User user3 = new User("u3", "p3");
		userMapper.insertSelective(user1);
		log.info("user1回写主键-[{}]",user1.getId());
		userMapper.insertSelective(user2);
		log.info("user2回写主键-[{}]",user2.getId());
		userMapper.insertSelective(user3);
		log.info("user3回写主键-[{}]",user3.getId());
		final int count = userMapper.countByUsername("u1");
		log.info("[调用自己写的SQL] - [{}]",count);

		//模拟分页
		userMapper.insertSelective(new User("u1","p1"));
		userMapper.insertSelective(new User("u1","p1"));
		userMapper.insertSelective(new User("u1","p1"));
		userMapper.insertSelective(new User("u1","p1"));
		userMapper.insertSelective(new User("u1","p1"));
		userMapper.insertSelective(new User("u1","p1"));
		userMapper.insertSelective(new User("u1","p1"));
		// TODO 分页 + 排序 this.userMapper.selectAll() 这一句就是我们需要写的查询，有了这两款插件无缝切换各种数据库
		final PageInfo<Object> pageInfo = PageHelper.startPage(1,10).setOrderBy("id desc").doSelectPageInfo(() -> this.userMapper.selectAll());
		log.info("lambda语法",pageInfo.toString());
		PageHelper.startPage(1,10).setOrderBy("id desc");
		final PageInfo<User> userPageInfo = new PageInfo<>(this.userMapper.selectAll());
		log.info("[普通写法] - [{}]",userPageInfo);
	}
}

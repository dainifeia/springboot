package com.aididi.springbootjdbctemplate.controller;

import com.aididi.springbootjdbctemplate.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xuzexiang
 * @Date: 2018/8/27 0027
 * @Description:
 */
@Controller
@RequestMapping("/users")
public class HelloController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HelloController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<User> queryUsers(){
        String sql = "select * from t_user";
        return jdbcTemplate.query(sql,new Object[]{},new BeanPropertyRowMapper<>(User.class));
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        String sql = "select * from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(User.class));
    }

    @PostMapping
    @ResponseBody
    public int addUser(@RequestBody User user){
        String sql="insert into t_user(username,password) values (?,?)";
        return jdbcTemplate.update(sql,user.getUsername(),user.getPassword());
    }

    @PutMapping("/{id}")
    public int updateUser(@PathVariable Long id,@RequestBody User user){
        String sql="update t_user set username=? ,password=? where id=?";
        return jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),id);
    }

    @DeleteMapping("/{id}")
    public int delUser(@PathVariable Long id){
        String sql="delete from t_user where id =?";
        return jdbcTemplate.update(sql,id);

    }

}

package com.aididi.controller;

import com.aididi.Dao.UserDao;
import com.aididi.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

/**
 * @author xuzexiang
 * @Date: 2018/7/10 0010
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    private UserDao userDao;

    @Autowired
    public LoginController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/login")
    public String login(UserEntity user, HttpServletRequest request){
        boolean flg = true;
        String result = "登录成功";
        //根据用户名查询用户是否存在
        UserEntity userEntity = userDao.findOne((root, query, cb) -> {
            query.where(cb.equal(root.get("name"),user.getName()));
            return null;
        });
        if(userEntity ==null){
            flg = false;
            result = "登录失败";
        }else if (userEntity.getPwd().equals(user.getPwd())){
            flg = false;
            result = "用户密码不相符，登录失败";
        }
        if(flg){
            request.getSession().setAttribute("_session_user",userEntity);
        }


        return result;
    }



}

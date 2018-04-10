package com.aididi.springbootlearning01;

import com.aididi.pojo.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("theaf")
public class ThymeleafController {

    @RequestMapping(value = "/index",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "/接口测试",notes = "测试接口文档")
    public String index(ModelMap map){
        map.addAttribute("name" ,"testthymeleaf");
        return "index";
    }

    @RequestMapping("userAll")
    public String getUser(ModelMap modelMap){
        UserVo userVo = new UserVo();
        userVo.setName("张三");
        userVo.setAge(18);
        userVo.setBrithday(new Date());
        userVo.setSex("1");
        userVo.setDesc("<font color='red'><span>猪八戒</span></font>");
        modelMap.addAttribute("user",userVo);
        return "thyme";
    }
    //使用该注解忽略这个API
    @ApiIgnore
    @RequestMapping("addUser")
    public String addUser(UserVo userVo){
        System.out.println("name:"+userVo.getName());
        System.out.println("name:"+userVo.getBrithday());
        return "redirect:/theaf/userAll";
    }

    @RequestMapping("userList")
    @ApiOperation(value = "测试userlist",notes = "userlist接口文档")
    public String getUserList(ModelMap modelMap){
        List<UserVo> list = new ArrayList<UserVo>();
        UserVo userVo1 = new UserVo();
        userVo1.setName("张三");
        userVo1.setAge(18);
        userVo1.setBrithday(new Date());
        userVo1.setSex("1");
        userVo1.setDesc("<font color='red'><span>猪八戒</span></font>");

        UserVo userVo2 = new UserVo();
        userVo2.setName("李四");
        userVo2.setAge(48);
        userVo2.setBrithday(new Date());
        userVo2.setSex("1");
        userVo2.setDesc("<font color='red'><span>猪八戒</span></font>");

        UserVo userVo3 = new UserVo();
        userVo3.setName("王五");
        userVo3.setAge(34);
        userVo3.setBrithday(new Date());
        userVo3.setSex("1");
        userVo3.setDesc("<font color='red'><span>猪八戒</span></font>");
        list.add(userVo1);
        list.add(userVo2);
        list.add(userVo3);
        modelMap.addAttribute("userlist",list);
        return "userList";
    }

}

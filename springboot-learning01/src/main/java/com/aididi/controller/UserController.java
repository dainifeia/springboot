package com.aididi.controller;

import com.aididi.vo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Auther: Administrator
 * @Date: 2018/4/19 0019 16:28
 * @Description:
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    static Map<Long,User> map = Collections.synchronizedMap(new HashMap<Long,User>());

    @ApiOperation(value = "获取所有用户",notes = "获取用户所有信息")
   @RequestMapping(value = "/userList", method=RequestMethod.GET)
   public List<User> getUserList(){
        List<User> users = new ArrayList<User>(map.values());
        return users;
    }

    @ApiOperation(value = "获创建用户",notes = "根据用户对象创建用户信息")
    @ApiImplicitParam(name = "user",value = "创建用户实体对象",required = true,dataType = "User")
    @RequestMapping(value = "/createUser",method = RequestMethod.POST)
    public String CreateUser(@RequestBody User user){
        map.put(user.getId(),user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息",notes = "根据id获取一条用户信息")
    @ApiImplicitParam(name = "id" ,value = "用户id",required = true,dataType = "Long")
    @GetMapping(value = "/getUser/{id}")
    public User getUser(@PathVariable Long id){
        return map.get(id);
    }


    @ApiOperation(value = "更新用户信息",notes = "根据id更新用户详细信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Long"),
                        @ApiImplicitParam(name = "user",value = "用户对象",required = true,dataType = "User")})
    @PutMapping(value = "/updateUser/{id}")
    @ResponseBody
    public String putUser(@PathVariable Long id,User user){
        User user1 = map.get(id);
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        map.put(id,user1);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        map.remove(id);
        return "success";
    }

}

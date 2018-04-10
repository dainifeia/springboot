package com.aididi.springbootlearning01;

import com.aididi.util.JSONResult;
import com.aididi.util.ResourceUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    public static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ResourceUtil resourceUtil;

    @RequestMapping(value = "/getResource")
    @ResponseBody
    @ApiOperation(value = "测试home",notes = "HOME接口文档")
    public JSONResult getResource(){
        logger.info("loggertest-----");
        ResourceUtil bean = new ResourceUtil();
        BeanUtils.copyProperties(resourceUtil,bean);
        return JSONResult.ok(bean);

    }

    @RequestMapping("/login")
    public String login(){
        return  "login";
    }
}

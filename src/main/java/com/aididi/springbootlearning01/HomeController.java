package com.aididi.springbootlearning01;

import com.aididi.util.JSONResult;
import com.aididi.util.ResourceUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private ResourceUtil resourceUtil;

    @RequestMapping(value = "/getResource")
    @ResponseBody
    public JSONResult getResource(){
        ResourceUtil bean = new ResourceUtil();
        BeanUtils.copyProperties(resourceUtil,bean);
        return JSONResult.ok(bean);

    }
}

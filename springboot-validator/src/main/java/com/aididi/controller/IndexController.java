package com.aididi.controller;

import com.aididi.entity.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author xuzexiang
 * @Date: 2018/7/11 0011
 * @Description:
 */
@RestController
public class IndexController {
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/validator")
    public String validator(@Valid DemoEntity demoEntity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuffer sb = new StringBuffer();
            //获取错误字段集合
            List<FieldError> errorList = bindingResult.getFieldErrors();
            //获取本地locale,zh_CN
            Locale locale =  LocaleContextHolder.getLocale();
            //遍历错误字段获取错误消息
            for(FieldError fieldError : errorList){
              String errorMessage = messageSource.getMessage(fieldError,locale);
                sb.append(fieldError.getField()+":"+errorMessage+",");
            }
            return sb.toString();
        }
        return "验证通过，"+"名称："+demoEntity.getName()+",年龄："+demoEntity.getAge()+",邮箱："+demoEntity.getMail();
    }
}

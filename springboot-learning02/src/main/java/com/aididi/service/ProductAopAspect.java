package com.aididi.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ProductAopAspect {
	
	@Autowired
	ProductService productService;
	
	// 使用要拦截标注有AdminOnly的注解进行操作
    @Pointcut("@annotation(com.aididi.anno.AdminOnly)")
	public void adminOnly() {
		
	}
    
    @Before("adminOnly()")
    public void check() {
    	try {
			productService.checkAccess();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
   

}	

package com.aididi.springbootjdbctemplate.service.impl;

import com.aididi.springbootjdbctemplate.service.EnviromentService;

/**
 * @author xuzexiang
 * @Date: 2018/8/27 0027
 * @Description:
 */
public class WindowService implements EnviromentService{
    @Override
    public void print() {
        System.out.println("这是window环境");
    }
}

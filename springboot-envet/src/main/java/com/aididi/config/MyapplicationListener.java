package com.aididi.config;

import org.springframework.context.ApplicationListener;

/**
 * @author xuzexiang
 * @Date: 2018-10-9 0009
 * @Description:
 */
public class MyapplicationListener implements ApplicationListener<MyApplicationEvent> {
    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        System.out.println("--");
        System.out.println("事件"+event.getClass());

    }
}

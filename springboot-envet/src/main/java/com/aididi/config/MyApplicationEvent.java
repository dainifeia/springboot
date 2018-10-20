package com.aididi.config;

import org.springframework.context.ApplicationEvent;

/**
 * @author xuzexiang
 * @Date: 2018-10-9 0009
 * @Description:
 */
public class MyApplicationEvent extends ApplicationEvent{

    private static final long serialVersionUID = -5054800325274970509L;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyApplicationEvent(Object source) {
        super(source);
    }
}

package com.aididi.enums;

import lombok.Getter;

/**
 * @author xuzexiang
 * @Date: 2018/7/10 0010
 * @Description:
 */
public enum  MailSenderEnum {
    HTML("text/html;charset=UTF_*"),
    TEXT("text")
    ;
    @Getter
    private String value;


    MailSenderEnum(String s) {
        this.value = s;
    }

}

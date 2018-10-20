package com.aididi.vo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 功能描述:
 * @param:
 * @return:
 * @auther: xuzexiang
 * @date: 2018/6/26 0026 上午 10:06
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Editor {
    @Id
    @GeneratedValue
    private Integer id;

    private String content;

    private String textContent="";

    /**
     * 创建时间
     */
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Override
    public String toString() {
        return "Editor{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}

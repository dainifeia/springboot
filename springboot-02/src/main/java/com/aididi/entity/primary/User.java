package com.aididi.entity.primary;

import lombok.Data;

import javax.persistence.*;

/**
 * @author xuzexiang
 * @Date: 2018/7/5 0005
 * @Description:
 */
@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    /**
     * TODO 忽略该字段的映射
     */
    @Transient
    private String nickName;

}

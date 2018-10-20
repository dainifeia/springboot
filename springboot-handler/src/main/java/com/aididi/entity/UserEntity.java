package com.aididi.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author xuzexiang
 * @Date: 2018/7/10 0010
 * @Description:
 */
@Entity
@Table(name = "user")
@Data
public class UserEntity implements Serializable{
    @GeneratedValue
    @Id
    @Column(name = "t_id",nullable = false)
    private Long id;
    @Column(name = "t_name")
    private String name;
    @Column(name = "t_address")
    private String address;
    @Column(name = "t_age")
    private int age;
    @Column(name = "t_pwd")
    private String pwd;


}

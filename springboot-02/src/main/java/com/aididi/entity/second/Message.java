package com.aididi.entity.second;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

/**
 * @author xuzexiang
 * @Date: 2018/7/5 0005
 * @Description:
 */
@Entity
@Table(name = "message")
@Data
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;
}

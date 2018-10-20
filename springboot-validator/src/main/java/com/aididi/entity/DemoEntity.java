package com.aididi.entity;

import com.aididi.validator.MyValidator;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author xuzexiang
 * @Date: 2018/7/11 0011
 * @Description:
 */
@Data
public class DemoEntity implements Serializable {
    @NotBlank
    @Length(max = 20,min = 2)
    private String name;

    @Min(value = 1)
    private int age;

    @NotBlank
    @Email
    private String mail;

    @MyValidator(values = "1,2,3")
    private String flg;
}

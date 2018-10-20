package com.aididi.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author xuzexiang
 * @Date: 2018/7/11 0011
 * @Description:
 */
public class ValidatorClass implements ConstraintValidator<MyValidator,Object>{
    //临时变量保存flag值列表
    private String values;

    /**
     * 初始化values的值
     */
    @Override
    public void initialize(MyValidator constraintAnnotation) {
        //将注解内配置的值赋值给临时变量

        this.values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        //分割定义的有效值
        String [] value_array = values.split(",");
        boolean isflg = false;
        for (int i =0;i<value_array.length;i++){
            //存在一致跳出循环，赋值isFlag=true
            if(value_array[i].equals(values)){
                isflg  = true;
                break;
            }
        }

        return isflg;

    }
}

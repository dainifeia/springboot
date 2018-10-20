package test02;

import test01.Test01;

import java.util.Collections;

/**
 * @author xuzexiang
 * @Date: 2018-10-17 0017
 * @Description:
 */
public class Test022 extends Test01{
    protected void func1(){
        System.out.println(name);
    }
    public static void main(String[] args) {

            String name="ss";
        new Test022().func1();
    }
}

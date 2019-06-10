package com.lg.demo.classloader;


import org.junit.Test;

public class HelloTest {

    /**
     * 测试Hello实例化
     */
    @Test
    public void testInstance(){
        new Hello();
    }

    /** 测试调用Hello的静态方法*/
    @Test
    public void testStaticMethodInvoke(){
        Hello.hello();
    }

    /**测试静态域被赋值*/
    @Test
    public void testStaticFieldAssigned(){
        Hello.c = 20;
    }

    /**测试调用Hello的常量A*/
    @Test
    public void testConstantA(){
       int a =  Hello.A;
        System.out.println("a="+a);
    }

    /**测试调用Hello的常量B*/
    @Test
    public void testConstantVariableB(){
       int b =  Hello.B;
        System.out.println("b=" + b);
    }

    @Test
    public void testConstantVariableC(){
       int c =  Hello.c;
        System.out.println("c=" + c);
    }

    /** 测试所有情况*/
    @Test
    public void testAll(){
        new Hello();
        Hello.hello();
        System.out.println("Hello.A=" + Hello.A);
        System.out.println("Hello.B=" + Hello.B);
    }




}

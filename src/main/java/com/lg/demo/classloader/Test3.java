package com.lg.demo.classloader;

//-XX:+TraceClassLoading 用于追踪类加载信息
public class Test3 {
    public static void main(String[] args) {
        new Hello(); //实例化Hello
        //Hello.getA();//调用Hello的一个静态方法
        //Hello.c = 1; //给Hello的静态域c赋值
        //System.out.println(Hello.A); //使用Hello的常量A
        //System.out.println("B=" + Hello.B); //使用Hello的常量变量B
    }
}

package com.lg.demo.classloader;

import java.util.UUID;

/**
 * 1.对于静态域，只有直接定义该静态域(包括静态方法)的类才会被初始化
 * 2.对于静态常量，会在编译时，将静态常量加入到引用类的常量池中，
 * 当使用时直接从常量池中获取，而不会初始化定义该常量的类.
 * 3.当常量在编译期无法确定时(例子中的h6,h7)，那么就不会将这个常量放入到调用类的常量池中，
 * 这将导致调用类再使用该常量时初始化定义该常量的类
 */
public class Test4 {
    public static void main(String[] args) {
        //System.out.println(MyChild.hello);
        //System.out.println(MyChild.h1);
        //System.out.println(MyChild.h2);
        //System.out.println(MyChild.h3);
        //System.out.println(MyChild.h4);
        //System.out.println(MyChild.h5);
        //System.out.println(MyChild.h6);
        System.out.println(MyChild.h7);
    }
}

class MyParent {
    public static String hello = "hello";

    public static final String h1 = "this is a final field";
    public static final short h2 = 1;
    public static final short h3 = 7;
    public static final int h4 = 2;
    public static final int h5 = 7;
    public static final String h6 = UUID.randomUUID().toString();

    static {
        System.out.println("parent init...");
    }
}

class MyChild extends MyParent {
    public static String world = "world";
    public static final String h7;

    static {
        System.out.println("child init...");
        h7 = "我是一个h7";
    }
}



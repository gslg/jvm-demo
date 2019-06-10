package com.lg.demo.classloader;

/**
 * Test2
 */
public class Hello {

    public static final int A = initA();
    public static final int B = 10;
    public static int c;

    static {
        System.out.println("Hello静态代码块加载了1.........");
    }

    static {
        System.out.println("Hello静态代码块加载了2.........");
    }

    public Hello() {
        System.out.println("Hello构造函数初始化了........");
    }

    public static void hello() {
        System.out.println("Hello.hello方法被调用了........");
    }

    public static int initA() {
        System.out.println("Hello.initA方法被调用了........");
        return 10;
    }
}

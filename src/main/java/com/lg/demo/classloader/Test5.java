package com.lg.demo.classloader;

import java.util.Random;

/**
 * 1.当仅仅调用<code>MyParent5.a,MyChild5.a or MyChild5.b</code>时,
 * 通过反编译Test5.class可以发现在编译期就已经将a,b的值加入到Test5的常量池中了，后续使用就不会涉及到MyParent5或者MyChild5了
 * 这也从侧面证明在接口中定义的变量都默认是public static final类型的
 *
 * 2.同时通过例子可以证明：
 *      当一个接口初始化时，并不要求其父接口都完成初始化
 *      只有在真正使用到父接口的时候(如引用接口中定义的常量)，才会被初始化.
 */
public class Test5 {
    public static void main(String[] args) {
        //System.out.println(MyParent5.a);
        //System.out.println(MyChild5.a);
        //System.out.println(MyChild5.a1);
        //System.out.println(MyChild5.b);
        //System.out.println(MyChild5.c);
        System.out.println(MyGrandson.h);
    }
}

interface MyParent5 {
    int a = 5;
    int a1 = new Random().nextInt(4);
    Object o1 = new Object() {
        {
            System.out.println("MyParent5 接口初始化了");
        }
    };
}

interface MyChild5 extends MyParent5 {
    int b = 6;
    int c = new Random().nextInt(4);

    Object o = new Object() {
        {
            System.out.println("MyChild5 接口初始化了");
        }
    };
}

class Baba {
    public static int h1 = 3;

    static {
        System.out.println("Baba被初始化了......");
    }

    public static Object o = new Object() {
        {
            System.out.println("Baba被初始化了2......");
        }
    };
}

class MyGrandson extends Baba implements MyChild5 {

    public static int h = 7;

    static {
        //b = 9; //b是final 不能再赋值
        System.out.println("MyGrandson init.....");
    }
}

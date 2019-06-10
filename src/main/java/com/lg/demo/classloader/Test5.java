package com.lg.demo.classloader;

import java.util.Random;

/**
 * 1.当仅仅调用<code>MyParent5.a,MyChild5.a or MyChild5.b</code>时,
 * 通过反编译Test5.class可以发现在编译期就已经将a,b的值加入到Test5的常量池中了，后续使用就不会涉及到MyParent5或者MyChild5了
 * 这也从侧面证明在接口中定义的变量都默认是public static final类型的
 */
public class Test5 {
    public static void main(String[] args) {
        //System.out.println(MyParent5.a);
        //System.out.println(MyChild5.a);
        System.out.println(MyChild5.b);
        //System.out.println(MyChild5.c);
    }
}

interface MyParent5 {
    int a = 5;
}

interface MyChild5 extends MyParent5 {
    int b = 6;
    int c = new Random().nextInt(4);
}

class MyGrandson implements MyChild5 {
    static {
        //b = 9; //b是final 不能再赋值
    }
}

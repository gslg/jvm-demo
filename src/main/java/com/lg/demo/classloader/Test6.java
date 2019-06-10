package com.lg.demo.classloader;

/**
 * 加载: 加载class文件
 * 链接：
 *  - 验证: 验证class文件是否合法
 *  - 准备: 将静态变量赋予默认初始值
 * 初始化：
 *  - 为静态变量赋予实际值
 *=======================================
 * 在Singleton中，在类的准备阶段count1,count2的值均为0,在<code>Singleton.getSingleton()</code>触发初始化操作,
 * 对于静态变量来说，初始化是按静态变量定义的顺序进行初始化的.
 * ①count1 = 0
 * ②count2 = 0
 * ③构造函数中进行++操作，所以结果都是1
 * =================================
 * 同理，在Singleton1中，我们交换了<code>public static int count2 = 0;</code>
 * 和<code>public static Singleton1 singleton = new Singleton1();</code>的定义顺序。
 * 在准备阶段,各静态域的默认值为:
 *    count1 = 0
 *    singleton = null
 *    count2 = 0
 *  在我们调用<code>Singleton1.getSingleton()</code>时触发初始化操作，而初始化操作是按静态变量定义顺序进行的:
 * ①初始化count1 = 0
 * ②初始化singleton = new Singleton2()这里会调用构造函数,结果导致:
 *   count1 = 1
 *   count2 = 1
 * ③初始化count2 = 0。这里将count2又初始化为实际赋予的值
 * 因此最后输出:
 *   count1 = 1,count2 = 0
 * =================================
 * 知道类的初始化的各个阶段作用和顺序后再推断Singleton2就很简单了:
 * count1=2,count2 = 0
 */
public class Test6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();

        System.out.println("Counter1:" + Singleton.count1);
        System.out.println("Counter2:" + Singleton.count2);

        System.out.println("***********************************");
        Singleton1 singleton1 = Singleton1.getSingleton();
        System.out.println("Counter1:" + Singleton1.count1);
        System.out.println("Counter2:" + Singleton1.count2);

        System.out.println("***********************************");
        Singleton2 singleton2 = Singleton2.getSingleton();
        System.out.println("Counter1:" + Singleton2.count1);
        System.out.println("Counter2:" + Singleton2.count2);

        /** output://
         * Counter1:1
         * Counter2:1
         * ***********************************
         * Counter1:1
         * Counter2:0
         * ***********************************
         * Counter1:2
         * Counter2:0
         */

    }
}

class Singleton {
    public static int count1;

    public static int count2 = 0;

    public static Singleton singleton = new Singleton();

    public Singleton() {
        count1++;
        count2++;
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}

class Singleton1 {
    public static int count1;

    public static Singleton1 singleton = new Singleton1();

    public static int count2 = 0;

    public Singleton1() {
        count1++;
        count2++;
    }

    public static Singleton1 getSingleton() {
        return singleton;
    }
}

class Singleton2 {
    public static int count1 = 1;

    public static Singleton2 singleton = new Singleton2();

    public static int count2 = 0;

    public Singleton2() {
        count1++;
        count2++;
    }

    public static Singleton2 getSingleton() {
        return singleton;
    }
}
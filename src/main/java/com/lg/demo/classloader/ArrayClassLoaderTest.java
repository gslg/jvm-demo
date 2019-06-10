package com.lg.demo.classloader;

/**
 * 对于数组实例来说，其类型时由JVM运行期动态生成的，表示为[Lxx.xxx..这种形式。动态生成的类型，其父类型就是Object.
 * 助记符:
 *  newarray: 表示创建一个指定的原始类型(如int,float,char等)的数组，并将其压入栈顶
 *  anewarray: 表示创建一个引用类型的（如类,接口，数组）数组，并将其压入栈顶
 */
public class ArrayClassLoaderTest {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        System.out.println(a.getClass().getClassLoader());
        System.out.println(a.getClass());


        String[] b = new String[]{"hello","word"};
        System.out.println(b.getClass().getClassLoader());
        System.out.println(b.getClass());

        Integer[] c = new Integer[]{1,2,3,4,5};
        System.out.println(c.getClass().getClassLoader());
        System.out.println(c.getClass());

        Hello[] hellos = new Hello[1];
        System.out.println(hellos.getClass());
        System.out.println(hellos.getClass().getSuperclass());
        System.out.println(hellos.getClass().getClassLoader());

    }
}

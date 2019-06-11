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
        System.out.println("class loader: " + a.getClass().getClassLoader());
        System.out.println(a.getClass());


        String[] b = new String[]{"hello","word"};
        //null,因为String.class是由根加载器(BootStrapLoader)加载的,由根加载器加载的class对象，
        // 在获取classloader时可能返回null,这个由具体的实现不同可能返回null代表根加载器
        System.out.println("class loader: " + b.getClass().getClassLoader());
        System.out.println(b.getClass());

        Integer[] c = new Integer[]{1,2,3,4,5};
        System.out.println("class loader: " + c.getClass().getClassLoader());
        System.out.println(c.getClass());

        Hello[] hellos = new Hello[1];
        System.out.println(hellos.getClass());
        System.out.println(hellos.getClass().getSuperclass());
        System.out.println("class loader: " + hellos.getClass().getClassLoader());

    }
}

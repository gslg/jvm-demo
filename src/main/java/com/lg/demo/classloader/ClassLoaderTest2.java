package com.lg.demo.classloader;

import java.util.Objects;

/**
 * 类加载器
 *
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) throws
            ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = ClassLoaderTest2.class.getClassLoader();
        System.out.println(loader);
        Class<?> test1 = loader.loadClass("com.lg.demo.classloader.Hello");
        System.out.println(test1);

        System.out.println("***********************");
        Class<?> test2 = Class.forName("com.lg.demo.classloader.Hello", false, loader);
        System.out.println(test2.newInstance());
        Class<?> test3 = Class.forName("com.lg.demo.classloader.Hello", true, loader);
        System.out.println(test2 == test3);

        System.out.println(String.class.getClassLoader());

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        System.out.println(Objects.equals(systemClassLoader,loader));//true


    }
}

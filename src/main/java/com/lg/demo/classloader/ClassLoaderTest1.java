package com.lg.demo.classloader;


public class ClassLoaderTest1 {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }
}

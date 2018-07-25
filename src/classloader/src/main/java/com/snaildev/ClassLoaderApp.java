package com.snaildev;

import com.snaildev.pojo.People;

/**
 * Hello world!
 */
public class ClassLoaderApp {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());

        ClassLoader loader1 = People.class.getClassLoader();
        System.out.println(loader1);

        // 使用ClassLoader.loadClass()来加载类，不会执行初始化块
        loader1.loadClass("com.snaildev.pojo.People");
        // 使用Class.forName()来加载类，默认会执行初始化块
        //Class.forName("com.snaildev.pojo.People");
        // 使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
        //Class.forName("com.snaildev.pojo.People", false, loader1);
    }
}

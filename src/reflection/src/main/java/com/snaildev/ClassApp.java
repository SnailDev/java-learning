package com.snaildev;

import com.snaildev.pojo.Book;

/**
 * Reflection
 */
public class ClassApp {
    public static void main(String[] args) {
        Class book1 = null;
        Class book2 = null;
        Class book3 = null;

        // 第一种获取Class对象的方法
        try {
            book1 = Class.forName("com.snaildev.pojo.Book");
            System.out.println("book1=====> " + book1);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        // 第二种获取Class对象的方法
        Object book = new Book();
        book2 = book.getClass();
        System.out.println("book2=====> " + book2);

        // 第三种获取Class对象的方法
        book3 = Book.class;
        System.out.println("book3=====> " + book3);

        System.out.println("book3=====> " + book3.getName());
    }
}

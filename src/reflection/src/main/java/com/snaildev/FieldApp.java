package com.snaildev;

import com.snaildev.pojo.Book;

import java.lang.reflect.Field;

public class FieldApp {
    public static void main(String[] args) {
        Book book = new Book(1, "走在人生边上", "散文");

        show(book);
    }

    private static void show(Book book) {
        Class cl = book.getClass();
        Field[] fields = cl.getDeclaredFields();
        for (Field field:
             fields) {
            field.setAccessible(true);

            try {
                System.out.println("属性名称====> "+ field.getName()+ ", 属性值====> "+field.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

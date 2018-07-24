package com.snaildev;


import com.snaildev.pojo.Book;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorApp {
    public static void main(String[] args) {
        Class book3 = Book.class;
        Constructor<?>[] constructors = book3.getConstructors();
        for (Constructor constructor :
                constructors) {
            System.out.println(constructor);
        }

        // newInstance 创建一个Book对象
        try {
            Constructor constructor = book3.getConstructor();
            Book book4 = (Book) constructor.newInstance();
            System.out.println("book4=====> " + book4);

            constructor = book3.getConstructor(int.class, String.class, String.class);
            Book book5 = (Book) constructor.newInstance(1,"Benzi","1.0.0");
            System.out.println("book5=====> " + book5);
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

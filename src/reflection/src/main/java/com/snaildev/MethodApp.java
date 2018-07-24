package com.snaildev;

import com.snaildev.pojo.Book;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodApp {
    public static void main(String[] args) {
        Book book = new Book(2, "活着", "小说");
        showInvoke(book);
    }

    private static void showInvoke(Book book) {
        Class cl = book.getClass();
        Method[] methods = cl.getDeclaredMethods();

        // 查看信息
        for (Method method :
                methods) {
            System.out.println("方法名称：" + method.getName());
            System.out.println("方法返回值类型：" + method.getReturnType());
            System.out.println("方法修饰符标号：" + method.getModifiers());
            System.out.println("方法修饰符：" + Modifier.toString(method.getModifiers()));
            System.out.println("方法的注解信息为：");
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation :
                    annotations) {
                System.out.print(annotation);
            }
            System.out.println("方法的参数列表为：");
            Class[] cls = method.getParameterTypes();
            for (Class cl1 :
                    cls) {
                System.out.print(" " + cl1.getName());
            }
            System.out.println();
        }

        // 调用
        try {
            Method method1 = cl.getMethod("setName", String.class);
            System.out.println(method1.invoke(book, "平凡的世界"));

            Method method2 = cl.getMethod("getName", new Class[0]);
            System.out.println(method2.invoke(book, new Object[0]));

            Method method3 = cl.getMethod("print", new Class[]{String.class, int.class});
            method3.invoke(book, new Object[]{"哈哈哈哈", 3});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

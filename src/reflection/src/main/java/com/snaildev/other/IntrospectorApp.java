package com.snaildev.other;

import com.snaildev.pojo.Book;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class IntrospectorApp {
    public static void main(String[] args) throws Exception {
        Book book = new Book(3, "莽荒纪", "小说");
        String propertyName = "name";
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, book.getClass());
        Method method = propertyDescriptor.getReadMethod();
        Object name = method.invoke(book, null);
        System.out.println("名字：" + name);
        propertyDescriptor.getWriteMethod().invoke(book, "盘龙");
        name = method.invoke(book, null);
        System.out.println("名字：" + name);

        BeanInfo beanInfo = Introspector.getBeanInfo(book.getClass(), Object.class);
        System.out.println("所有属性描述：");
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd :
                propertyDescriptors) {
            System.out.println(pd.getName());
        }
        System.out.println("所有方法描述：");
        for (MethodDescriptor methodDescriptor :
                beanInfo.getMethodDescriptors()) {
            System.out.println(methodDescriptor.getName());
        }
    }
}

package com.snaildev.other;

import com.snaildev.pojo.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionApp {
    public static void main(String[] args) throws Throwable {
        Car car1 = initByDefaultConst();
        Car car2 = initByParamConst();

        car1.introduce();
        car2.introduce();
    }

    /**
     * 通过默认的构造方法来实例化car，并获取car的相关属性
     *
     * @return
     * @throws Throwable
     */
    private static Car initByDefaultConst() throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        Class clazz = loader.loadClass("com.snaildev.pojo.Car");
        Constructor constructor = clazz.getConstructor((Class[]) null);

        Object obj = constructor.newInstance();
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(obj, "奔驰");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(obj, "黑色");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(obj, 100);

        return (Car) obj;
    }

    /**
     * 获取类的带有参数的构造器对象来实例化car并设置相关的属性
     * @return
     * @throws Throwable
     */
    private static Car initByParamConst() throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        Class clazz = loader.loadClass("com.snaildev.pojo.Car");
        Constructor constructor = clazz.getConstructor(new Class[]{String.class, String.class, int.class});
        Object obj = constructor.newInstance(new Object[]{"宝马", "白色", 90});

        return (Car)obj;
    }
}

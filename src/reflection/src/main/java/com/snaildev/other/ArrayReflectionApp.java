package com.snaildev.other;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayReflectionApp {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[5];
        int[][] arr3 = new int[2][3];

        System.out.println(arr1.getClass() == arr2.getClass());

        // Error:(10, 44) java: 不可比较的类型: java.lang.Class<capture#1, 共 ? extends int[]>和java.lang.Class<capture#2, 共 ? extends int[][]>
        // System.out.println(arr1.getClass() == arr3.getClass());

        System.out.println(arr1.getClass());
        System.out.println(arr3.getClass());
        System.out.println(arr1.getClass().getSuperclass() == arr3.getClass().getSuperclass());
        System.out.println(arr2.getClass().getSuperclass());

        // Error:(19, 29) java: 不兼容的类型: int[]无法转换为java.lang.Object[]
        // Object[] objects1 = arr1;
        Object[] objects2 = arr3;

        String str1 = "123";
        System.out.println(Arrays.asList(arr1));
        System.out.println(Arrays.asList(str1));
    }
}

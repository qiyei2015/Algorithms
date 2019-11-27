package com.qiyei.array;

import com.qiyei.util.LogUtil;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/4/27.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class ArrayTest {


    public static void main(String[] args){

//        testDynamicArray();

        testTwoDimensionalArray();
    }


    private static void testDynamicArray() {
        com.qiyei.array.DynamicArray<Integer> integerDynamicArray = new com.qiyei.array.DynamicArray<>();
        Random random = new Random();

        for (int i = 0 ;i < 100 ;i++){
            integerDynamicArray.add(random.nextInt(1000));
        }
        LogUtil.println(integerDynamicArray.toString());

        for (int i = 0 ;i < 80 ;i++){
            integerDynamicArray.remove();
        }
        LogUtil.println(integerDynamicArray.toString());
    }

    private static void testTwoDimensionalArray(){
        int size = 4;
        int[][] array = new int[size][size];
        int k = 0;
        for (int i = 0 ;i < size ;i++){
            for (int j = 0 ;j < size;j++){
                array[i][j] = ++k;
            }
        }
        com.qiyei.array.ArrayUtil.printTwoDimensionalArray(array, com.qiyei.array.ArrayUtil.Dir.NONE);
//        ArrayUtil.printTwoDimensionalArray(array, ArrayUtil.Dir.TOP_LEFT);
//        ArrayUtil.printTwoDimensionalArray(array,ArrayUtil.Dir.TOP_RIGHT);
        com.qiyei.array.ArrayUtil.printTwoDimensionalArray(array, com.qiyei.array.ArrayUtil.Dir.BOTTOM_LEFT);
        com.qiyei.array.ArrayUtil.printTwoDimensionalArray(array, com.qiyei.array.ArrayUtil.Dir.BOTTOM_RIGHT);
    }
}

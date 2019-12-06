package com.qiyei.backup.array;

import com.qiyei.datastructure.array.Array;
import com.qiyei.backup.util.LogUtil;

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
        Array<Integer> integerArray = new Array<>();
        Random random = new Random();

        for (int i = 0 ;i < 100 ;i++){
            integerArray.addLast(random.nextInt(1000));
        }
        LogUtil.println(integerArray.toString());

        for (int i = 0 ;i < 80 ;i++){
            integerArray.removeLast();
        }
        LogUtil.println(integerArray.toString());
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
        ArrayUtil.printTwoDimensionalArray(array, ArrayUtil.Dir.NONE);
//        ArrayUtil.printTwoDimensionalArray(array, ArrayUtil.Dir.TOP_LEFT);
//        ArrayUtil.printTwoDimensionalArray(array,ArrayUtil.Dir.TOP_RIGHT);
        ArrayUtil.printTwoDimensionalArray(array, ArrayUtil.Dir.BOTTOM_LEFT);
        ArrayUtil.printTwoDimensionalArray(array, ArrayUtil.Dir.BOTTOM_RIGHT);
    }
}

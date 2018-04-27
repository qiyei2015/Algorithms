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

        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();
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
}

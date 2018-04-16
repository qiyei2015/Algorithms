package com.qiyei.heap;

import com.qiyei.util.LogUtil;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/4/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class HeapTest {


    public static void main(String[] args){

        Integer[] array = new Integer[100];
        Random random = new Random();
        for (int i = 0 ; i < 100;i++){
            array[i] = random.nextInt(100);
        }

        MinPQ<Integer> minPQ = new MinPQ<>(array);
        MaxPQ<Integer> maxPQ = new MaxPQ<>(array);
        for (int i = 0 ; i < 100 ;i++){
            LogUtil.print(minPQ.delMin() + " ");
        }
        LogUtil.println("");
        for (int i = 0 ; i < 100 ;i++){
            LogUtil.print(maxPQ.delMax() + " ");
        }
        LogUtil.println("");
    }


}

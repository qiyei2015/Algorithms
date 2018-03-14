package com.qiyei.sort;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/3/14.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SortTest {


    public static void main(String[] args){
        Random random = new Random(1234567);
        Integer[] a = new Integer[100];
        for (int i = 0;i< a.length ;i++){
            a[i] = random.nextInt(1000);
        }

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(a);
        selectionSort.print(a);


    }

}

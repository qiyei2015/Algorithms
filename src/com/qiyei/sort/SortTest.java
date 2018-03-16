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
        Integer[] a1 = new Integer[100];
        Integer[] a2 = new Integer[100];
        for (int i = 0;i< 100 ;i++){
            a1[i] = random.nextInt(1000);
            a2[i] = random.nextInt(1000);
        }

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(a1);
        selectionSort.print(a1);

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(a2);
        insertionSort.print(a2);

    }

}

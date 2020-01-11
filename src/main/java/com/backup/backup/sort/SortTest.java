package com.backup.backup.sort;

import com.backup.backup.util.LogUtil;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/3/14.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SortTest {


    public static void main(String[] args){
//        testSort1();
        testRankN();
    }

    private static void testSort1() {
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


    private static void testRankN(){
        int size = 100;
        Random random = new Random(1234567);
        Integer[] a1 = new Integer[size];
        for (int i = 0;i< size ;i++){
            a1[i] = random.nextInt(1000);
        }
        int k = 3;
        QuickSort quickSort = new QuickSort();
        quickSort.sortThreeWays(a1);
        quickSort.print(a1);
        LogUtil.println("第" + k + "大数是：" + quickSort.search(a1,k));

    }

}

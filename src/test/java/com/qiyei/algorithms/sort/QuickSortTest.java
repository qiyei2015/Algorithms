package com.qiyei.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.Executors;

/**
 * @author Created by qiyei2015 on 2019/12/18.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class QuickSortTest {

    QuickSort quickSort;
    Integer[] array ;

    @Before
    public void setUp() throws Exception {
        quickSort = new QuickSort();
        int size = 100;
        array = new Integer[size];
        for (int i = 0 ; i < size ; i++){
            array[i] = new Random().nextInt(size);
        }
    }

    @Test
    public void sort() {
        quickSort.sort(array);
        quickSort.print(array);
        Assert.assertEquals(quickSort.isSort(array),true);
    }

    @Test
    public void sortTwoWays() {
        quickSort.sortTwoWays(array);
        quickSort.print(array);
        Assert.assertEquals(quickSort.isSort(array),true);
    }

    @Test
    public void sortThreeWays() {
        quickSort.sortThreeWays(array);
        quickSort.print(array);
        Assert.assertEquals(quickSort.isSort(array),true);
    }

    private void quick(int[] arr,int l,int r){
        if (l >= r){
            return;
        }
        int val = arr[l];
        //[l+1.. lt] < val
        int lt = l;
        //[gt..r] > val
        int gt =  r + 1;
        //[lt + 1..i) == val
        int i = l+ 1;

        while (i < gt){
            if (arr[i] < val){
                swap(arr,i,lt+1);
                lt++;
                i++;
            } else if (arr[i] > val){
                swap(arr,i,gt-1);
                gt--;
            } else {
                i++;
            }
        }

        //
        swap(arr,l,lt);
        quick(arr,l,lt-1);
        quick(arr,gt,r);
    }

    protected void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        Executors.newCachedThreadPool();
    }
}
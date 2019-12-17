package com.qiyei.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2019/12/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class MergeSortTest {

    MergeSort mergeSort;
    Integer[] array ;

    @Before
    public void setUp() throws Exception {
        mergeSort = new MergeSort();
        int size = 1000;
        array = new Integer[size];
        for (int i = 0 ; i < size ; i++){
            array[i] = new Random().nextInt(size);
        }
        //mergeSort.print("original",array);
    }

    @Test
    public void sort() {
        mergeSort.sort(array);
        mergeSort.print(array);
        Assert.assertEquals(mergeSort.isSort(array),true);
    }

    @Test
    public void sortBU() {
        mergeSort.sortBU(array);
        mergeSort.print(array);
        Assert.assertEquals(mergeSort.isSort(array),true);
    }
}
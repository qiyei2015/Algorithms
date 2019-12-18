package com.qiyei.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

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
            array[i] = new Random().nextInt(size/10);
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
}
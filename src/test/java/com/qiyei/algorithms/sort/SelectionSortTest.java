package com.qiyei.algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2019/12/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SelectionSortTest {

    SelectionSort selectionSort;
    Integer[] array ;

    @Before
    public void setUp() throws Exception {
        selectionSort = new SelectionSort();
        array = new Integer[100];
        for (int i = 0 ; i < 100 ; i++){
            array[i] = new Random().nextInt(1000);
        }
    }

    @Test
    public void sort() {
        selectionSort.sort(array);
        Assert.assertEquals(selectionSort.isSort(array),true);
        selectionSort.print(array);
    }
}
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
public class BubbleSortTest {
    BubbleSort bubbleSort;
    Integer[] array ;

    @Before
    public void setUp() throws Exception {
        bubbleSort = new BubbleSort();
        int size = 1000;
        array = new Integer[size];
        for (int i = 0 ; i < size ; i++){
            array[i] = new Random().nextInt(size);
        }
    }

    @Test
    public void sort() {
        bubbleSort.sort(array);
        Assert.assertEquals(bubbleSort.isSort(array),true);
        bubbleSort.print(array);
    }

    @Test
    public void sort2() {
        bubbleSort.sort(array);
        Assert.assertEquals(bubbleSort.isSort(array),true);
        bubbleSort.print(array);
    }
}
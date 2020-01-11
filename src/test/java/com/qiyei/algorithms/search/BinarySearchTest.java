package com.qiyei.algorithms.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Created by qiyei2015 on 2020/1/11.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class BinarySearchTest {

    int[] array;
    int[] array2;
    int[] array3;

    @Before
    public void setUp() throws Exception {
        array = new int[]{0,1,2,3,4,5,6,7,8,9,10};
        array2 = new int[]{1,3,4,8,9,12,13,14,15,16};
        array3 = new int[]{1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,10,11,12,13,14,16};
    }

    @Test
    public void search() {
        System.out.println("array1=" + BinarySearch.search(5,array));
        System.out.println("array2=" + BinarySearch.search(5,array2));
        System.out.println("array3=" + BinarySearch.search(5,array3));
    }

    @Test
    public void search2() {
        System.out.println("array1=" + BinarySearch.search2(5,array));
        System.out.println("array2=" + BinarySearch.search2(5,array2));
        System.out.println("array3=" + BinarySearch.search2(5,array3));
    }

    @Test
    public void search3() {
        System.out.println("array1=" + BinarySearch.search3(5,array));
        System.out.println("array2=" + BinarySearch.search3(5,array2));
        System.out.println("array3=" + BinarySearch.search3(5,array3));
    }
}
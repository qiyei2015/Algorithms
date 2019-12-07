package com.qiyei.datastructure.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Created by qiyei2015 on 2019/12/7.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class MaxHeapTest {


    MaxHeap<Integer> maxHeap = new MaxHeap<>();

    @Before
    public void setUp() throws Exception {
        for (int i = 0 ; i < 10;i++){
            maxHeap.add(i);
        }
    }

    @Test
    public void size() {
        Assert.assertEquals(maxHeap.size(),10);
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(maxHeap.isEmpty(),false);
    }

    @Test
    public void add() {
        System.out.println(maxHeap);
    }

    @Test
    public void extractMax() {
        System.out.println(maxHeap);
        Assert.assertEquals(maxHeap.extractMax().intValue(),9);
    }

    @Test
    public void findMax() {
        System.out.println(maxHeap);
        Assert.assertEquals(maxHeap.findMax().intValue(),9);
    }

    @Test
    public void replace() {
        System.out.println(maxHeap);
        System.out.println(maxHeap.replace(96));
        System.out.println(maxHeap);
    }
}
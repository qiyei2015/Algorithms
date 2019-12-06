package com.qiyei.datastructure.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Created by qiyei2015 on 2019/11/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class ArrayQueueTest {

    ArrayQueue<Integer> queue;


    @Before
    public void setUp() throws Exception {
        queue = new ArrayQueue<>(10);
        for (int i = 0 ;i < 9;i++){
            queue.enqueue(i);
        }
    }

    @Test
    public void enqueue() {
        for (int i = 0 ;i < 9;i++){
            queue.enqueue(i);
        }
        System.out.println(queue.toString());
    }

    @Test
    public void dequeue() {
        for (int i = 0 ;i < 5;i++){
            System.out.println("dequeue=" + queue.dequeue());
        }
        System.out.println(queue.toString());
    }

    @Test
    public void getFront() {
        for (int i = 0 ;i < 5;i++){
            System.out.println("getFront=" + queue.getFront());
        }
        System.out.println(queue.toString());
    }

    @Test
    public void size() {
        Assert.assertEquals(queue.size(),9);
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(queue.isEmpty(),false);
    }

    @Test
    public void testToString() {

    }
}
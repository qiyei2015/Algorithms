package com.qiyei.datastructure.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Created by qiyei2015 on 2019/12/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LinkedListQueueTest {


    private LinkedListQueue<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = new LinkedListQueue<>();
        for (int i = 0 ; i < 6;i++){
            queue.enqueue(i);
        }
        System.out.println(queue.toString());
        for (int i = 0 ; i < 2;i++){
            queue.dequeue();
        }
        System.out.println(queue.toString());
    }


    @Test
    public void enqueue() {
        queue.enqueue(100);
        System.out.println(queue);
    }

    @Test
    public void dequeue() {
        Assert.assertEquals(queue.dequeue().intValue(),2);
        System.out.println(queue);
    }

    @Test
    public void getFront() {
        Assert.assertEquals(queue.getFront().intValue(),2);
        System.out.println(queue);
    }

    @Test
    public void size() {
        Assert.assertEquals(queue.size(),4);
        System.out.println(queue);
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(queue.isEmpty(),false);
        System.out.println(queue);
    }
}
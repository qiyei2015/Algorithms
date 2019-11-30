package com.qiyei.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Created by qiyei2015 on 2019/12/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LoopQueueTest {

    private LoopQueue<Integer> loopQueue;

    @Before
    public void setUp() throws Exception {
        loopQueue = new LoopQueue<>();
        for (int i = 0 ; i < 6;i++){
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue.toString());
        for (int i = 0 ; i < 2;i++){
            loopQueue.dequeue();
        }
        System.out.println(loopQueue.toString());
    }

    @Test
    public void enqueue() {
        loopQueue.enqueue(100);
        System.out.println(loopQueue.toString());
    }

    @Test
    public void dequeue() {
        loopQueue.dequeue();
        System.out.println(loopQueue.toString());
    }

    @Test
    public void getFront() {
        Assert.assertEquals(loopQueue.dequeue().intValue(),2);
    }

    @Test
    public void size() {
        Assert.assertEquals(loopQueue.size(),4);
    }

    @Test
    public void isEmpty() {

    }

    @Test
    public void getCapacity() {
        Assert.assertEquals(loopQueue.getCapacity(),10);
        for (int i = 0;i < 7;i++){
            loopQueue.enqueue(i);
        }
        Assert.assertEquals(loopQueue.getCapacity(),20);
    }
}
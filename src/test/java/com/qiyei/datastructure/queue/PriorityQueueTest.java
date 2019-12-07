package com.qiyei.datastructure.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author Created by qiyei2015 on 2019/12/7.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class PriorityQueueTest {

    private PriorityQueue<Integer> priorityQueue;


    @Before
    public void setUp() throws Exception {
        priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(1);
        priorityQueue.enqueue(85);
        priorityQueue.enqueue(25);
    }

    @Test
    public void enqueue() {
        for (int i = 0; i < 8;i++){
            priorityQueue.enqueue(new Random().nextInt(100));
        }
        System.out.println(priorityQueue);
    }

    @Test
    public void dequeue() {
        int size = priorityQueue.size();
        System.out.println("size=" + size);
        for (int i = 0; i < size;i++){
            System.out.println(priorityQueue.dequeue());
        }

    }

    @Test
    public void getFront() {
        System.out.println(priorityQueue.getFront());
    }

    @Test
    public void size() {

    }

    @Test
    public void isEmpty() {

    }
}
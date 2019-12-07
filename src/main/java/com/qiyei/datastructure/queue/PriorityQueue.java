package com.qiyei.datastructure.queue;

import com.qiyei.datastructure.heap.MaxHeap;

import java.util.Comparator;

/**
 * @author Created by qiyei2015 on 2019/12/7.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 基于最大堆实现的优先队列
 */
public class PriorityQueue<E extends Comparable<E>> implements IQueue<E>{

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<E>();
    }

    public PriorityQueue(Comparator<? super E> comparator) {
        maxHeap = new MaxHeap<E>(comparator);
    }


    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "maxHeap=" + maxHeap +
                '}';
    }
}

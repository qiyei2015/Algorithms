package com.qiyei.datastructure.queue;

import com.qiyei.datastructure.array.Array;

/**
 * @author Created by qiyei2015 on 2019/11/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class ArrayQueue<E> implements IQueue<E>{

    protected Array<E> array;


    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue:size=%d,capacity=%d\n",array.size(),array.getCapacity()));
        builder.append("[");
        for (int i = 0 ; i < size() ; i++){
            builder.append(array.get(i));
            if (i != size() - 1){
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}

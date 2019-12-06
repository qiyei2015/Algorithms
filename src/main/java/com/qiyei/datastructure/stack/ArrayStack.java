package com.qiyei.datastructure.stack;

import com.qiyei.datastructure.array.Array;

/**
 * @author Created by qiyei2015 on 2019/11/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class ArrayStack<E> implements IStack<E> {

    private Array<E> array;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
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
        builder.append(String.format("Stack:size=%d\n",array.size()));
        builder.append("[");
        for (int i = 0 ; i < size() ; i++){
            builder.append(array.get(i));
            if (i != size() - 1){
                builder.append(",");
            }
        }
        builder.append("] Top");
        return builder.toString();
    }
}

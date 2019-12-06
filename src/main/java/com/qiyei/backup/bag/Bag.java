package com.qiyei.backup.bag;

import java.util.Iterator;

/**
 * @author Created by qiyei2015 on 2018/3/9.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class Bag<T> implements Iterable<T> {

    public static final String TAG = "Bag";
    private Node<T> mFirst;
    private int mSize;


    /**
     * 添加到链表中
     * @param t
     */
    public void add(T t){
        Node temp = mFirst;

        mFirst = new Node<>();
        mFirst.data = t;
        mFirst.next = temp;
        mSize++;
    }

    public int size(){
        return mSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }


    /**
     * 内部类
     * @param <T>
     */
    private class Node<T>{
        T data;
        Node next;
    }

    /**
     * 迭代器
     */
    private class ListIterator implements Iterator<T>{

        Node<T> node = mFirst;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T t = node.data;
            node = node.next;
            return t;
        }
    }

}

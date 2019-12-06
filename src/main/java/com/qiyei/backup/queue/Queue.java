package com.qiyei.backup.queue;

import java.util.Iterator;

/**
 * @author Created by qiyei2015 on 2018/3/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 队列的链表实现
 */
public class Queue<T> implements Iterable<T> {

    public static final String TAG = "Queue";

    /**
     * 头结点
     */
    private Node<T> mFirst;
    /**
     * 末结点
     */
    private Node<T> mLast;

    private int mSize;

    /**
     * 入队
     * @param item
     */
    public void enqueue(T item){
        Node temp = mLast;
        mLast = new Node();
        mLast.data = item;
        mLast.next = null;

        //如果为null
        if (isEmpty()){
            mFirst = mLast;
        }else {
            temp.next = mLast;
        }
        mSize++;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue(){
        T t = mFirst.data;
        mFirst = mFirst.next;
        mSize--;
        //为null需要将last置为null
        if (isEmpty()){
            mLast = null;
        }
        return t;
    }


    /**
     * 大小
     * @return
     */
    public int size(){
        return mSize;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return mFirst == null;
    }


    public void removeLast(){
        for (Node node = mFirst; node != null ; node = node.next ){
            //尾结点的上一个结点
            if (node.next.next == null){
                node.next = null;
                mSize--;
            }else if (node.next == null){
                node = null;
                mSize--;
            }
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
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
     * @param
     */
    private class QueueIterator implements Iterator<T>{

        @Override
        public boolean hasNext() {
            return mFirst != null;
        }

        @Override
        public T next() {
            T t = mFirst.data;
            //指向下一个结点
            mFirst = mFirst.next;
            return t;
        }

        @Override
        public void remove() {
            dequeue();
        }
    }

}

package com.qiyei.backup.stack;

import java.util.Iterator;

/**
 * @author Created by qiyei2015 on 2018/3/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 栈的数组形式，可调整大小
 */
public class ResizingArrayStack<T> implements Iterable<T> {

    public static final String TAG = "ResizingArrayStack";

    /**
     * 数据存储
     */
    private T[] datas;
    /**
     * 栈大小
     */
    private int size;


    public ResizingArrayStack() {
        this(1);
    }

    /**
     * 构造方法
     * @param size
     */
    public ResizingArrayStack(int size) {
        datas = (T[]) new Object[size];
    }

    /**
     * 入栈
     * @param item
     */
    public void push(T item){
        //调整大小，如果满了就扩大二倍数组
        if (size == datas.length){
            resize(2 * datas.length);
        }
        datas[size++] = item;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        T t = datas[size - 1];
        datas[size - 1] = null;
        size--;

        //调整大小，节约空间，如果size 等于大小的四分之一，就减少数组大小
        if (size > 0 && size == datas.length / 4){
            resize(datas.length / 2);
        }
        return t;
    }

    /**
     * 栈大小
     * @return
     */
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }

    /**
     * 将栈重新调整到max大小
     * @param max
     */
    private void resize(int max){
        T[] temp = (T[]) new Object[max];
        for (int i = 0 ; i < size ; i++){
            temp[i] = datas[i];
        }
        datas = temp;
    }

    /**
     * 迭代器
     * @param
     */
    private class ArrayStackIterator implements Iterator<T>{

        private int i = size;

        @Override
        public boolean hasNext() {
            return i != 0;
        }

        @Override
        public T next() {
            return datas[--i];
        }

        @Override
        public void remove() {
            pop();
        }
    }
}

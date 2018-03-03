package com.qiyei.stack;

import com.qiyei.p001.Evaluate;
import com.qiyei.util.LogUtil;

import java.util.Iterator;

/**
 * @author Created by qiyei2015 on 2018/3/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 栈，链表实现
 */
public class Stack<T> implements Iterable<T>{

    private static final String TAG = "Stack";

    private int mSize;

    private Node<T> mTop;

    public Stack() {
        mTop = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    /**
     * 入栈
     * @param item
     */
    public void push(T item){
        //临时保存mTop
        Node<T> temp = mTop;
        //构造结点 在链表头插入
        Node<T> node = new Node<>();
        node.data = item;
        node.next = temp;
        //更新表头
        mTop = node;

        mSize++;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        //取值
        T t = mTop.data;
        //更新表头
        mTop = mTop.next;
        mSize--;
        return t;
    }

    /**
     * 栈大小
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
        return mTop == null;
    }

    /**
     * 链表节点
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
    private class StackIterator implements Iterator<T>{

        @Override
        public boolean hasNext() {
            return mTop != null;
        }

        @Override
        public T next() {
            return mTop.data;
        }

        @Override
        public void remove() {
            pop();
        }
    }

    public static void main(String[] args){
        //7.333333
        String express = "( ( ( 2 * 5 ) + ( 4 / 3 ) ) - ( 1 + 3 ) )";
        String[] array = express.split(" ");

        Stack<String> stringStack = new Stack<>();
        Stack<Double> numStack = new Stack<>();
        LogUtil.println(TAG,"" + new Evaluate().calculateExpression3(array,numStack,stringStack));
    }


}

package com.qiyei.datastructure.stack;

/**
 * @author Created by qiyei2015 on 2019/11/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public interface IStack<E> {

    void push(E e);

    E pop();

    E peek();

    int size();

    boolean isEmpty();

}

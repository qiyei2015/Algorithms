package com.qiyei.datastructure.queue;

/**
 * @author Created by qiyei2015 on 2019/11/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public interface IQueue<E> {

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 队首
     * @return
     */
    E getFront();

    int size();

    boolean isEmpty();

}

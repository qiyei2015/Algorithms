package com.qiyei.linked;

/**
 * @author Created by qiyei2015 on 2018/4/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class Node<T> {

    public T data;
    public Node next;

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}

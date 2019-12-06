package com.qiyei.set;

/**
 * @author Created by qiyei2015 on 2019/12/5.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:集合的数据结构
 */
public interface ISet<E> {

    /**
     * 添加元素
     */
    void add(E e);

    /**
     * 删除元素
     * @param e
     */
    void remove(E e);

    /**
     * 包含元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 集合大小
     * @return
     */
    int size();

    /**
     * 是否为NULL
     * @return
     */
    boolean isEmpty();
}

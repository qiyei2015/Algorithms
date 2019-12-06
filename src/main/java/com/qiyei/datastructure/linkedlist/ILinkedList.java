package com.qiyei.datastructure.linkedlist;

/**
 * @author Created by qiyei2015 on 2019/12/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public interface ILinkedList<E> {

    /**
     * 添加链表 结点
     * @param e
     */
    void addFirst(E e);

    /**
     * 添加结点到链表后面
     * @param e
     */
    void addLast(E e);

    /**
     * 在索引为index处添加结点
     * @param index
     * @param e
     */
    void add(int index,E e);

    /**
     * 删除第一个元素
     * @return
     */
    E removeFirst();

    /**
     * 删除最后一个元素
     * @return
     */
    E removeLast();

    /**
     * 删除index处的结点
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 删除指定元素
     * @param e
     */
    void removeElement(E e);

    /**
     * 修改元素
     * @param index
     * @param e
     */
    void set(int index,E e);

    /**
     * 查询元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 返回e的所以，若不存在返回-1
     * @param e
     * @return
     */
    int indexOf(E e);

    /**
     * 查询第一个元素
     * @return
     */
    E getFirst();

    /**
     * 获取最后一个元素
     * @return
     */
    E getLast();

    /**
     * 获取索引为index的结点
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 获取大小
     * @return
     */
    int size();
}

package com.qiyei.datastructure.stack;


import com.qiyei.datastructure.linkedlist.SingleLinkedList;


/**
 * @author Created by qiyei2015 on 2019/12/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LinkedListStack<E> implements IStack<E> {

    /**
     * 链表头作为栈顶
     */
    private SingleLinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new SingleLinkedList<>();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Stack:size=%d\n",size()));
        builder.append("Top[");
        for (int i = 0 ; i < size() ; i++){
            builder.append(linkedList.get(i));
            if (i != size() - 1){
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}

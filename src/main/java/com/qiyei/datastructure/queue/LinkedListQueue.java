package com.qiyei.datastructure.queue;

/**
 * @author Created by qiyei2015 on 2019/12/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LinkedListQueue<E> implements IQueue<E> {

    /**
     * 链表结点
     * @param <E>
     */
    private static class Node<E> {

        public E value;
        public Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this.value = value;
        }

        public Node() {

        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    /**
     * 头结点,出队操作head
     */
    private Node<E> head;
    /**
     * 尾结点,入队操作tail
     */
    private Node<E> tail;
    /**
     * 大小
     */
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        Node<E> node = new Node<>(e);
        //队列为NULL时
        if (tail == null){
            tail = node;
            head = tail;
        }else {
            //更新tail
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    /**
     * 操作头指针
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()){
            return null;
        }

        Node<E> node = head;
        //更新head
        head = head.next;
        //队列为NULL
        if (head == null){
            tail = null;
        }
        size--;
        return node.value;
    }

    @Override
    public E getFront() {
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue:size=%d\n",size));
        builder.append("Front [");
        Node<E> p = head;
        while (p != null){
            builder.append(p.value);
            if (p.next != null){
                builder.append(",");
            }
            p = p.next;
        }
        builder.append("]");
        return builder.toString();
    }


}

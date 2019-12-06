package com.qiyei.datastructure.linkedlist;

/**
 * @author Created by qiyei2015 on 2019/12/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class TailLinkedList<E> implements ILinkedList<E> {

    public static final String NODE_ARROW = " -> ";

    /**
     * 单链表结点
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
            StringBuilder builder = new StringBuilder();
            Node<E> p = this;
            while (p != null){
                builder.append(p.value + NODE_ARROW);
                p = p.next;
            }
            builder.append("NULL");
            return builder.toString();
        }
    }


    /**
     * 虚拟头结点
     */
    private Node<E> dummyHead;
    /**
     * 尾结点
     */
    private Node<E> tail;

    /**
     * 链表结点数量
     */
    private int size;


    public TailLinkedList() {
        size = 0;
        dummyHead = new Node<>();
        tail = null;
    }

    @Override
    public void addFirst(E e) {
        add(0,e);
    }

    @Override
    public void addLast(E e) {
        add(size,e);
    }

    @Override
    public void add(int index, E e) {

    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public void removeElement(E e) {

    }

    @Override
    public void set(int index, E e) {

    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}

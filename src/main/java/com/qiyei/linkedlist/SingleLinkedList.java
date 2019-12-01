package com.qiyei.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/4/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 链表
 */
public class SingleLinkedList<E> {

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
            return value.toString();
        }
    }

    /**
     * 头结点
     */
    private Node dummyHead;

    /**
     * 链表结点数量
     */
    private int size;

    public SingleLinkedList() {
        size = 0;
        dummyHead = new Node<>();
    }

    /**
     * 添加链表 结点
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 添加结点到链表后面
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 在索引为index处添加结点
     * @param index
     * @param e
     */
    public void add(int index,E e){
        checkRangeForAdd(index);

        Node p = dummyHead;
        //循环index次，找到index的前一个结点
        for (int i = 0 ;i < index; i++){
            p = p.next;
        }

        Node<E> node = new Node<>(e);
        node.next = p.next;
        p.next = node;

        size++;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除index处的结点
     * @param index
     * @return
     */
    public E remove(int index){
        checkRangeForGet(index);

        Node prev = dummyHead;
        for (int i = 0 ;i < index ;i++){
            prev = prev.next;
        }

        //删除结点
        Node<E> del = prev.next;
        prev.next = del.next;
        del.next = null;
        size--;

        return del.value;
    }

    /**
     * 修改元素
     * @param index
     * @param e
     */
    public void set(int index,E e){
        checkRangeForGet(index);

        Node p = dummyHead.next;
        for (int i = 0 ;i < index;i++){
            p = p.next;
        }
        p.value = e;
    }

    /**
     * 查询元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node p = dummyHead.next;
        while (p != null){
            if (p.value.equals(e)){
                return true;
            }
            p = p.next;
        }
        return false;
    }

    /**
     * 查询第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取索引为index的结点
     * @param index
     * @return
     */
    public E get(int index){
        checkRangeForGet(index);

        Node<E> p = dummyHead.next;
        //获取到index处的结点
        for (int i = 0; i < index ;i++){
            p = p.next;
        }
        return p.value;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return dummyHead.next == null;
    }

    public int size(){
        return size;
    }

//    /**
//     * 反转链表结点
//     */
//    public SingleLinkedList<E> reverse(){
//        Node<E> p = dummyHead;
//        Node<E> newHead = null;
//
//        while (p != null){
//            //保存p的下一个结点
//            Node<E> temp = p.next;
//            //上一次头结点
//            Node tempHead = newHead;
//            //新头结点指向当前结点
//            newHead = p;
//            //当前头结点指向上一头结点
//            newHead.next = tempHead;
//            //更新p
//            p = temp;
//
//        }
//        //更新head
//        dummyHead = newHead;
//        return this;
//    }
//
//    /**
//     * 反转链表结点
//     */
//    public SingleLinkedList<E> reverse2(){
//        Node<E> p = dummyHead;
//        Node<E> newHead = null;
//
//        while (p != null){
//            //保存p的下一结点，防止p改变时无法获取下一个结点
//            Node<E> temp = p.next;
//            //p的下一个结点指向新的头结点
//            p.next = newHead;
//            //更新新头结点，让其指向p
//            newHead = p;
//            //更新p
//            p = temp;
//        }
//        //更新head
//        dummyHead = newHead;
//        return this;
//    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        //builder.append("[SingleLinkedList] ");
        Node<E> p = dummyHead.next;
        while (p != null){
            builder.append(p.value + NODE_ARROW);
            p = p.next;
        }
        builder.append("NULL");
        return builder.toString();
    }

    private void checkRangeForAdd(int index) {
        if (index < 0 || index > size){
            throw new IllegalArgumentException("checkRangeIllegal index=" + index);
        }
    }

    private void checkRangeForGet(int index) {
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("checkRangeIllegal index=" + index);
        }
    }
}

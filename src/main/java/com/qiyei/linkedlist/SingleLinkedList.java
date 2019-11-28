package com.qiyei.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/4/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 链表
 */
public class SingleLinkedList<T> {

    public static final String NODE_ARROW = " -> ";

    /**
     * 单链表结点
     * @param <T>
     */
    public static class Node<T> {

        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this.data = data;
        }

        public Node() {
        }
    }

    /**
     * 头结点
     */
    private Node dummyHead;
    /**
     * 尾结点
     */
    private Node<T> last;

    /**
     * 个数
     */
    private int count;

    public SingleLinkedList() {
        count = 0;
        dummyHead = new Node<>();
        last = null;
    }

    /**
     * 添加链表 结点
     * @param t
     */
    public void addFirst(T t){
        addFirst(0,t);
    }

    /**
     * 添加到前面
     * @param index
     * @param t
     */
    public void addFirst(int index,T t){
        if (checkRangeIllegal(index)){
            return ;
        }
        Node p = dummyHead;
        //找到index的上一个结点
        for (int i = 0; i < index;i++){
            p = p.next;
        }

        Node node = new Node(t);

        //更新node结点，指向p原来next结点
        node.next = p.next;
        p.next = node;
        count++;
    }

    public void addLast(T t){
        if (isEmpty()){
            addLast(0,t);
        }else {
            addLast(count - 1,t);
        }
    }

    /**
     * 添加到后面
     * @param index
     * @param t
     */
    public void addLast(int index,T t){
        if (checkRangeIllegal(index)){
            return ;
        }
        Node p = dummyHead.next;
        //找到index结点
        for (int i = 0; i < index;i++){
            p = p.next;
        }

        Node node = new Node(t);
        count++;
        //为null时
        if (isEmpty()){
            dummyHead.next = node;
            return;
        }
        //更新node结点，指向p的下一个结点
        node.next = p.next;
        p.next = node;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return dummyHead.next == null;
    }

    public int size(){
        return count;
    }

    /**
     * 删除结点
     * @param node
     * @return
     */
    public Node remove(Node<T> node){
        Node p = dummyHead;
        //找到node的前一个结点
        while (p != null && p.next == node){
            p = p.next;
        }

        if (node == dummyHead){
            dummyHead = dummyHead.next;
            return node;
        }

        if (node == last){
            last = p;
        }

        //删除node
        p.next = node.next;
        Node temp = node;
        node.next = null;
        node = null;
        return temp;
    }

    public Node get(int index){
        if (checkRangeIllegal(index)){
            return null;
        }

        Node p = dummyHead.next;
        for (int i = 0; i < index ;i++){
            p = p.next;
        }
        return p;
    }

    /**
     * 反转链表结点
     */
    public Node<T> reverse(){
        Node<T> p = dummyHead;
        Node<T> newHead = null;

        //更新last
        last = p;

        while (p != null){

            //保存p的下一个结点
            Node<T> temp = p.next;

            //上一次头结点
            Node tempHead = newHead;

            //新头结点指向当前结点
            newHead = p;

            //当前头结点指向上一头结点
            newHead.next = tempHead;

            //更新p
            p = temp;

        }
        //更新head
        dummyHead = newHead;
        return newHead;
    }

    /**
     * 反转链表结点
     */
    public Node<T> reverse2(){
        Node<T> p = dummyHead;
        Node<T> newHead = null;

        //更新last
        last = p;

        while (p != null){
            //保存p的下一结点，防止p改变时无法获取下一个结点
            Node<T> temp = p.next;

            //p的下一个结点指向新的头结点
            p.next = newHead;
            //更新新头结点，让其指向p
            newHead = p;

            //更新p
            p = temp;

        }
        //更新head
        dummyHead = newHead;
        return newHead;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[SingleLinkedList] ");
        Node<T> p = dummyHead.next;
        while (p != null){
            builder.append(p.data);
            if (p.next != null){
                builder.append(NODE_ARROW);
            }
            p = p.next;
        }
        return builder.toString();
    }

    private boolean checkRangeIllegal(int index) {
        if (index < 0 || index > count){
            return true;
        }
        return false;
    }



}

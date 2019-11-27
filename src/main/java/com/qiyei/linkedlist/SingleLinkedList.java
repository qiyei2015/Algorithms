package com.qiyei.linkedlist;

import com.qiyei.util.LogUtil;

/**
 * @author Created by qiyei2015 on 2018/4/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 链表
 */
public class SingleLinkedList<T> {


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
    }

    /**
     * 头结点
     */
    private Node<T> head;
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
        head = null;
        last = null;
    }

    /**
     * 添加链表 结点
     * @param t
     */
    public void addNode(T t){

        //保存last
        Node<T> temp = last;

        last = new Node<>(t,null);
        if (isEmpty()){
            head = last;
        }else {
            temp.next = last;
        }
        count++;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * 获取链表
     * @return
     */
    public Node<T> getNodeList(){
        return head;
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
        Node p = head;
        //找到node的前一个结点
        while (p != null && p.next == node){
            p = p.next;
        }

        if (node == head){
            head = head.next;
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
        if (index < 0 || index >= count){
            return null;
        }
        Node p = head;
        for (int i = 0; i < index ;i++){
            p = p.next;
        }
        return p;
    }

    /**
     * 反转链表结点
     */
    public Node<T> reverse(){
        Node<T> p = head;
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
        head = newHead;
        return newHead;
    }

    /**
     * 反转链表结点
     */
    public Node<T> reverse2(){
        Node<T> p = head;
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
        head = newHead;
        return newHead;
    }



    /**
     * 打印结点
     * @param node
     */
    public void show(Node<T> node){
        Node<T> p = node;
        while (p != null){
            LogUtil.print(" " + p.data);
            p = p.next;
        }
        LogUtil.println("");
    }

}

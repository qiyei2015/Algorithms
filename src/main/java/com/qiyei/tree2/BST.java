package com.qiyei.tree2;

import java.util.*;

/**
 * @author Created by qiyei2015 on 2019/12/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 二分搜索树实现
 */
public class BST<E extends Comparable<E>> {

    /**
     * 结点定义
     * @param <E>
     */
    private static class Node<E>{
        E value;
        Node<E> left;
        Node<E> right;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> left, Node<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 根节点
     */
    private Node<E> root;
    /**
     * 结点个数
     */
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 获取大小
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否为NULL
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 添加结点
     * @param e
     */
    public void add(E e){
        root = add(root,e);
    }

    /**
     * 在以node为根结点的二叉树中添加结点，并返回添加后的根节点
     * @param node
     * @param e
     * @return
     */
    private Node<E> add(Node<E> node,E e){
        if (node == null){
            size++;
            return new Node<>(e);
        }
        if (e.equals(node.value)){
            return node;
        }

        if (e.compareTo(node.value) < 0){
            node.left = add(node.left,e);
        }else {
            node.right = add(node.right,e);
        }
        return node;
    }

    /**
     * 前序遍历 根结点 -> 左子树 -> 右子树
     * @return
     */
    public List<E> preOrder(){
        List<E> list = new ArrayList<>();
        preOrder(root,list);
        return list;
    }

    private void preOrder(Node<E> node,List<E> list){
        if (node == null){
            return;
        }

        list.add(node.value);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }

    /**
     * 前序遍历非递归实现
     * @return
     */
    public List<E> preOrderNR(){
        List<E> list = new ArrayList<>();

        //使用栈来记录之后要遍历那些结点
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node<E> cur = stack.pop();
            //先访问前序结点
            list.add(cur.value);

            //根据栈的特性，先压入右子树
            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        return list;
    }


    /**
     * 中序遍历 左子树 -> 根结点 -> 右子树
     * @return
     */
    public List<E> inOrder(){
        List<E> list = new ArrayList<>();
        inOrder(root,list);
        return list;
    }

    private void inOrder(Node<E> node,List<E> list){
        if (node == null){
            return;
        }
        inOrder(node.left,list);
        list.add(node.value);
        inOrder(node.right,list);
    }

    /**
     * 后序遍历 左子树 -> 右子树 -> 根结点
     * @return
     */
    public List<E> postOrder(){
        List<E> list = new ArrayList<>();
        postOrder(root,list);
        return list;
    }

    private void postOrder(Node<E> node,List<E> list){
        if (node == null){
            return;
        }

        postOrder(node.left,list);
        postOrder(node.right,list);
        list.add(node.value);
    }

    /**
     * 层序遍历
     * @return
     */
    public List<E> levelOrder(){
        List<E> list = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node<E> cur = queue.remove();
            list.add(cur.value);

            if (cur.left != null){
                queue.add(cur.left);
            }

            if (cur.right != null){
                queue.add(cur.right);
            }
        }
        return list;
    }

    /**
     * 删除BST中最小的值
     * @return
     */
    public E removeMin(){
        E e = mininum();
        root = removeMin(root);
        return e;
    }

    /**
     * 删除以node为根节点的最小值
     * @param node
     * @return 返回删除后的根节点
     */
    private Node<E> removeMin(Node<E> node){
        //找到最小元素了
        if (node.left == null){
            Node right = node.right;
            //方便垃圾回收
            node.right = null;
            size--;
            return right;
        }
        //继续在左子树中找
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除BST中最大的值
     * @return
     */
    public E removeMax(){
        E e = maxnum();
        root = removeMax(root);
        return e;
    }

    /**
     * 删除以node为根节点的最大值
     * @param node
     * @return 返回删除后的根节点
     */
    private Node<E> removeMax(Node<E> node){
        //找到最小元素了
        if (node.right == null){
            Node left = node.left;
            //方便垃圾回收
            node.left = null;
            size--;
            return left;
        }
        //继续在左子树中找
        node.right = removeMax(node.right);
        return node;
    }


    /**
     * 返回BST中最小的值
     * @return
     */
    public E mininum(){
        return mininum(root);
    }

    /**
     * 返回以node为根节点的BST的最小值
     * @param node
     * @return
     */
    private E mininum(Node<E> node){
        if (node.left == null){
            return node.value;
        }
        return mininum(node.left);
    }

    /**
     * 返回BST中最大的值
     * @return
     */
    public E maxnum(){
        return maxnum(root);
    }

    /**
     * 返回以node为根节点的BST的最小值
     * @param node
     * @return
     */
    private E maxnum(Node<E> node){
        if (node.right == null){
            return node.value;
        }
        return maxnum(node.right);
    }

    /**
     * 删除元素
     * @param e
     */
    public void remove(E e){
        root = remove(root,e);
    }

    /**
     * 在以node为根的BST中删除e,返回新的树的根
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node<E> node,E e){
        if (node == null){
            return null;
        }

        if (e.compareTo(node.value) < 0){
            node.left = remove(node.left,e);
            return node;
        } else if (e.compareTo(node.value) > 0){
            node.right = remove(node.right,e);
            return node;
        } else {

            if (node.left == null){
                Node right = node.right;
                //断开指向
                node.right = null;
                size--;
                return right;
            }

            if (node.right == null){
                Node left = node.left;
                //断开指向
                node.left = null;
                size--;
                return left;
            }
            //找到后继结点
            Node<E> newNode = findMin(node.right);
            newNode.left = node.left;
            //删除右子树最小的结点
            newNode.right = removeMin(node.right);
            node.left = null;
            node.right = null;
            return newNode;
        }
    }


    private Node<E> findMin(Node<E> node){
        if (node == null){
            return null;
        }
        if (node.left == null){
            return node;
        }
        return findMin(node.left);
    }
}

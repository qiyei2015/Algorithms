package com.qiyei.tree;

/**
 * @author Created by qiyei2015 on 2018/3/31.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 二分搜索树
 */
public class BST<K extends Comparable<K>,V> {

    /**
     * 根节点
     */
    private Node<K,V> root;

    private int count;

    /**
     * 插入节点
     * @param key
     * @param value
     */
    public void insert(K key,V value){
        root = insert(root,key,value);
    }

    /**
     * 判断是否为NULL
     * @return
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * 获取大小
     * @return
     */
    public int size(){
        return count;
    }


    /**
     * 内部类
     * @param <K>
     * @param <V>
     */
    static class Node<K extends Comparable<K>,V>{
        K key;
        V value;
        Node<K,V> left;
        Node<K,V> right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * 递归方式插入节点
     * @param root
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node root, K key, V value) {
        if (root == null){
            root = new Node(key,value);
            return root;
        }

        if (key.compareTo((K) root.key) == 0){
            //相等直接更新Value
            root.value = value;
            return root;
        }else if (key.compareTo((K) root.key) < 0){
            //在左子树中插入
            return insert(root.left,key,value);
        }else {
            //在右子树中插入
            return insert(root.right,key,value);
        }
    }


}

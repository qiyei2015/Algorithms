package com.qiyei.tree;

/**
 * @author Created by qiyei2015 on 2018/3/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 二叉树
 */
public class BinaryTree<T extends Comparable<T>> {
    /**
     * 数据
     */
    public T data;
    /**
     * 左子树
     */
    public BinaryTree<T> left;
    /**
     * 右子树
     */
    public BinaryTree<T> right;

    public BinaryTree(T data) {
        this.data = data;
    }

}

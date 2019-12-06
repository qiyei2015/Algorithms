package com.qiyei.backup.tree;

/**
 * @author Created by qiyei2015 on 2018/3/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 树的定义如下
 */
public class TreeNode<T extends Comparable<T>> {
    /**
     * 存储数据
     */
    public T data;
    /**
     * 指向第一个儿子结点
     */
    public TreeNode<T> child;
    /**
     * 指向兄弟结点
     */
    public TreeNode<T> brother;

}

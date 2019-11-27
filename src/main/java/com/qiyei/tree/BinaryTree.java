package com.qiyei.tree;

import com.qiyei.util.LogUtil;

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

    /**
     * 中序遍历 左 根 右
     * @param node
     */
    public void inOrder(BinaryTree<T> node){
        if (node == null){
            return;
        }
        //先遍历左子树
        inOrder(node.left);
        //遍历根节点
        LogUtil.print(" " + node.data);
        //遍历右子树
        inOrder(node.right);

    }

    /**
     * 前序遍历 根 左 右
     * @param node
     */
    public void preOrder(BinaryTree<T> node){
        if (node == null){
            return;
        }
        //遍历根节点
        LogUtil.print(" " + node.data);
        //先遍历左子树
        preOrder(node.left);
        //遍历右子树
        preOrder(node.right);

    }

    /**
     * 后序遍历 左 右 根
     * @param node
     */
    public void postOrder(BinaryTree<T> node){
        if (node == null){
            return;
        }
        //先遍历左子树
        postOrder(node.left);
        //遍历右子树
        postOrder(node.right);
        //遍历根节点
        LogUtil.print(" " + node.data);
    }
}

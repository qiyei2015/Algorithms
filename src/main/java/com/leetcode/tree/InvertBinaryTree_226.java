package com.leetcode.tree;

/**
 * @author Created by qiyei2015 on 2018/6/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree_226 {

    /**
     * 采用递归的思想
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        //反转左子树
        invertTree(root.left);
        //反转右子树
        invertTree(root.right);
        //交换左右子结点
        swapChild(root);
        return root;
    }

    /**
     * 交换左右两个子结点
     * @param node
     * @return
     */
    private void swapChild(TreeNode node){
        TreeNode node1 = node.left;
        node.left = node.right;
        node.right = node1;
    }
}

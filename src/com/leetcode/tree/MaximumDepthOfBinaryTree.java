package com.leetcode.tree;

/**
 * @author Created by qiyei2015 on 2018/6/18.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 104. 二叉树的最大深度
 */
public class MaximumDepthOfBinaryTree {

    /**
     * 使用递归 表示该树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //递归终止条件
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}

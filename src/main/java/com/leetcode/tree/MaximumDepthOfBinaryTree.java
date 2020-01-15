package com.leetcode.tree;

/**
 * @author Created by qiyei2015 on 2018/6/18.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {

    /**
     * 使用递归 表示该树的最大深度
     * @param node
     * @return
     */
    public int maxDepth(TreeNode node) {
        //递归终止条件
        if (node == null){
            return 0;
        }
        return Math.max(maxDepth(node.left),maxDepth(node.right)) + 1;
    }
}

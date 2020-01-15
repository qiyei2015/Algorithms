package com.leetcode.tree;

/**
 * @author Created by qiyei2015 on 2020/1/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree_111 {

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null){
            return 1;
        } else if (root.left != null && root.right == null){
            return minDepth(root.left) + 1;
        } else if (root.left == null && root.right != null){
            return minDepth(root.right) + 1;
        } else {
            return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
        }
    }

}

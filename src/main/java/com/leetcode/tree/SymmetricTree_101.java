package com.leetcode.tree;

/**
 * @author Created by qiyei2015 on 2020/2/22.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree_101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        } else if (left != null && right == null){
            return false;
        } else if (left == null && right != null){
            return false;
        } else {
            boolean ret = (left.val == right.val);
            if (ret){
                return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
            }
            return false;
        }
    }

}

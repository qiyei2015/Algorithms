package com.leetcode.tree;

/**
 * @author Created by qiyei2015 on 2020/2/22.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 */
public class SameTree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }

        if (p == null){
            return false;
        } else if (q == null){
            return false;
        } else {
            if (p.val != q.val){
                return false;
            }
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}

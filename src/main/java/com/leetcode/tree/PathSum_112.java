package com.leetcode.tree;

/**
 * @author Created by qiyei2015 on 2018/6/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 112. 路径总和 求路径总和 sum
 * https://leetcode-cn.com/problems/path-sum/
 */
public class PathSum_112 {

    /**
     * 求路径总和
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        //注意递归的终止条件
        if (root.left == null && root.right == null){
            return root.val == sum;
        }

        if (hasPathSum(root.left,sum - root.val)){
            return true;
        }

        if (hasPathSum(root.right,sum - root.val)){
            return true;
        }

        return false;
    }


}

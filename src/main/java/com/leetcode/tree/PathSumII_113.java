package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/1/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class PathSumII_113 {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null){
            return res;
        }

        if (root.right == null && root.left == null){
            //找到了路径
            if (sum == root.val){
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                res.add(list);
            }
            return res;
        }

        List<List<Integer>> listLeft = pathSum(root.left,sum - root.val);
        for (List<Integer> list: listLeft){
            list.add(0,root.val);
            res.add(list);
        }

        List<List<Integer>> listRight = pathSum(root.right,sum - root.val);
        for (List<Integer> list: listRight){
            list.add(0,root.val);
            res.add(list);
        }

        return res;
    }


}

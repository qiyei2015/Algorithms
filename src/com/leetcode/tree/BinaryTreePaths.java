package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/6/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 257. 二叉树的所有路径
 */
public class BinaryTreePaths {

    /**
     * 递归调用
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        //叶子节点
        if (root.left == null && root.right == null){
            list.add(""+root.val);
            return list;
        }

        List<String> leftList = binaryTreePaths(root.left);
        for (int i = 0 ;i < leftList.size(); i++){
            list.add(root.val + "->" + leftList.get(i));
        }
        List<String> rightList = binaryTreePaths(root.right);
        for (int i = 0 ;i < rightList.size(); i++){
            list.add(root.val + "->" + rightList.get(i));
        }
        return list;
    }

}

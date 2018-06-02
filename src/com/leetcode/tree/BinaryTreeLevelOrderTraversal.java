package com.leetcode.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 * @author Created by qiyei2015 on 2018/6/2.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 102. 二叉树的层次遍历
 */
public class BinaryTreeLevelOrderTraversal {

    static class NodeInfo{
        TreeNode node;
        int level;

        public NodeInfo(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }


    /**
     * 使用队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        /**
         * 记录结点与层级信息
         */
        Queue<NodeInfo> queue = new ArrayDeque<>();
        queue.add(new NodeInfo(root,0));
        while (!queue.isEmpty()){
            NodeInfo info = queue.poll();

            List<Integer> innerList = new ArrayList<>();
            //已经添加过了，就找到更新下
            if (info.level < list.size()){
                innerList = list.get(info.level);
                innerList.add(info.node.val);
                //更新数据
                list.set(info.level,innerList);
            }else if (info.level == list.size()){
                //没有添加过，就构造添加下
                innerList.add(info.node.val);
                //插入
                list.add(innerList);
            }
            if (info.node.left != null){
                //入队
                queue.add(new NodeInfo(info.node.left,info.level + 1));
            }
            if (info.node.right != null){
                //入队
                queue.add(new NodeInfo(info.node.right,info.level + 1));
            }
        }

        return list;
    }
}

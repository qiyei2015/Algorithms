package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by qiyei2015 on 2020/1/15.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal_94 {


    /**
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<Command> stack = new Stack<>();

        stack.push(new Command("go",root));

        while (!stack.isEmpty()){
            Command command = stack.pop();
            if (command.node == null){
                continue;
            }

            if (command.s.equals("print")){
                list.add(command.node.val);
            } else {
                stack.push(new Command("go",command.node.right));
                stack.push(new Command("print",command.node));
                stack.push(new Command("go",command.node.left));
            }
        }

        return list;
    }

}

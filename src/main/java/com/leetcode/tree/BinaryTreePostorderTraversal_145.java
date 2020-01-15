package com.leetcode.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by qiyei2015 on 2018/6/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 145. 二叉树的后序遍历 不使用递归
 */
public class BinaryTreePostorderTraversal_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
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
            }else if (command.s.equals("go")){
                //注意是后序遍历 遍历顺序是 左 右 根，根据栈的特性，需要反着入栈
                //打印根节点
                stack.push(new Command("print",command.node));
                stack.push(new Command("go",command.node.right));
                stack.push(new Command("go",command.node.left));
            }
        }
        return list;
    }
}

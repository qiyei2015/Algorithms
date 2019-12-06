package com.leetcode.tree;

import com.qiyei.backup.stack.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/6/2.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 144. 二叉树的前序遍历 不使用递归
 */
public class BinaryTreePreorderTraversal {

    /**
     * 使用栈来模拟递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
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
                //注意是前序遍历 遍历顺序是 根 左 右，根据栈的特性，需要反着入栈
                stack.push(new Command("go",command.node.right));
                stack.push(new Command("go",command.node.left));
                //打印根节点
                stack.push(new Command("print",command.node));
            }
        }
        return list;
    }

}

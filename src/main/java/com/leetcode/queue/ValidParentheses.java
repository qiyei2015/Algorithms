package com.leetcode.queue;

import com.qiyei.backup.util.LogUtil;

import java.util.Stack;

/**
 * @author Created by qiyei2015 on 2018/6/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ;i++){
            char c = s.charAt(i);
            if (isLeft(c)){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char item = stack.pop();
                boolean match = match(item,c);
                LogUtil.println("match:" + match);
                if (match){
                    continue;
                }else {
                    return false;
                }
            }
        }

        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    private boolean isLeft(char c){
        if (c == '{' || c == '[' || c == '('){
            return true;
        }
        return false;
    }

    private boolean match(char left,char right){
        LogUtil.println("left:" + left + " right:" + right);
        if (left == '(' && right == ')'){
            return true;
        }else if (left == '[' && right == ']'){
            return true;
        }else if (left == '{' && right == '}'){
            return true;
        }else {
            return false;
        }
    }
}

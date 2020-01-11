package com.leetcode.queue;

import com.backup.backup.util.LogUtil;

/**
 * @author Created by qiyei2015 on 2018/6/2.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 测试程序
 */
public class LeetCodeQuqueTest {

    public static void main(String[] args){
        testValidParentheses();

//        testTopKFrequentElements();
    }

    private static void testTopKFrequentElements(){
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        LogUtil.println(new TopKFrequentElements().topKFrequent(nums,2).toString());
    }

    private static void testValidParentheses(){
        String s = "()";
        LogUtil.println(s + ":"+new ValidParentheses().isValid(s));
        String s2 = "(]";
        LogUtil.println(s2 + ":"+new ValidParentheses().isValid(s2));
    }
}

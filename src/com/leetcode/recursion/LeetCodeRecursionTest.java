package com.leetcode.recursion;

import com.qiyei.util.LogUtil;

/**
 * @author Created by qiyei2015 on 2018/6/10.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 递归测试
 */
public class LeetCodeRecursionTest {


    public static void main(String[] args){
//        testPermutations();
        testCombinations();
    }

    private static void testPermutations(){
        int[] arr = new int[]{1,2,3};
        LogUtil.println(new Permutations().permute(arr).toString());
    }

    private static void testCombinations(){
        LogUtil.println(new Combinations().combine(4,2).toString());
    }
}

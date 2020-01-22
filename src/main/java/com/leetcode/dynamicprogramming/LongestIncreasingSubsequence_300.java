package com.leetcode.dynamicprogramming;

/**
 * @author Created by qiyei2015 on 2020/1/22.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence_300 {


    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0){
            return 0;
        }

        int length = nums.length;
        int[] memo = new int[length];
        for (int i = 0 ;i < memo.length ;i++){
            //初始对于每个元素来说是自己的最长子序列，因此长度都是1
            memo[i] = 1;
        }

        for (int i = 1;i < length;i++){
            for (int j = 0 ; j < i;j++){
                if (nums[i] > nums[j]){
                    //取各个数比较后的最大值
                    memo[i] = Math.max(memo[i],1 + memo[j]);
                }
            }
        }

        //取最大的数就是最长子序列
        int res = 1;
        for (int i = 0 ;i < memo.length ;i++){
            res = Math.max(res,memo[i]);
        }
        return res;
    }

}

package com.leetcode.dynamicprogramming;

/**
 * @author Created by qiyei2015 on 2020/1/19.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class HouseRobber_198 {

    int[] memo;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        memo = new int[nums.length];
        for (int i = 0;i < memo.length ;i++){
            memo[i] = -1;
        }

        //考虑f(n-1)的情况
        memo[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2 ;i >= 0 ;i--){
            for (int j = i; j < nums.length ;j++){
                //状态转移方程
                memo[i] = Math.max(memo[i],nums[j] + (j >= nums.length - 2 ? 0 : memo[j + 2]));
            }
        }

        return memo[0];
    }

    public int rob2(int[] nums) {
        memo = new int[nums.length];
        for (int i = 0;i < memo.length ;i++){
            memo[i] = -1;
        }
        return robHouse(nums,0);
    }

    /**
     * 考虑偷取编号为x的房子 [x...n-1]
     * @param x
     * @return
     */
    private int robHouse(int[] nums,int x){
        if (x >= nums.length){
            return 0;
        }
        if (memo[x] != -1){
            return memo[x];
        }

        for (int i = x;i < nums.length;i++){
            memo[x] = Math.max(memo[x],nums[i] + robHouse(nums,i + 2));
        }
        return memo[x];
    }
}

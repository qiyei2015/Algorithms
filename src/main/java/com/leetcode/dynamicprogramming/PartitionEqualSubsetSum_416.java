package com.leetcode.dynamicprogramming;

/**
 * @author Created by qiyei2015 on 2020/1/21.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class PartitionEqualSubsetSum_416 {

    private int[][] memo;


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0 ;i < nums.length ;i++){
            sum += nums[i];
        }
        if (sum % 2 != 0){
            return false;
        }
        int C = sum / 2 ;
        //memo[i] 表示[0..i]处的元素可以分割为c
        boolean[] memo = new boolean[C + 1];

        //初始化,对于遍历数组发现可以分割的
        for (int i = 0 ;i <= C ;i++){
            //第0个数可以放入c中
            if (nums[0] == i){
                memo[i] = true;
            }
        }

        for (int i = 1;i < nums.length ;i++){
            for (int j = C ;j >= nums[i] ;j--){
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }

        return memo[C];
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0 ;i < nums.length ;i++){
            sum += nums[i];
        }
        if (sum % 2 != 0){
            return false;
        }
        memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < memo.length;i++){
            for (int j = 0 ;j < memo[i].length ;j++){
                memo[i][j] = -1;
            }
        }

        return canPartition(nums,nums.length - 1,sum / 2);
    }

    /**
     * 考虑能从[0..index]处的元素的和为c
     * @param nums
     * @param index
     * @param c
     * @return
     */
    private boolean canPartition(int[] nums,int index,int c){
        if (index < 0 || index >= nums.length){
            return false;
        }

        if (c == 0){
            return true;
        }

        if (index == 0){
            return nums[0] == c;
        }

        if (memo[index][c] != -1){
            return memo[index][c] == 1;
        }

        boolean res = canPartition(nums,index - 1,c);
        if (c >= nums[index]){
            res = res || canPartition(nums,index - 1,c - nums[index]);
        }
        memo[index][c] = (res ? 1 : 0);

        return res;
    }
}

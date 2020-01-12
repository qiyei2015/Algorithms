package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2018/5/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 209
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum_209 {

    public int minSubArrayLen(int s, int[] nums) {
        int res = nums.length + 1;

        //[left..right]为滑动窗口
        int left = 0;
        int right = -1;
        int sum = 0;

        //循环继续条件
        while (left < nums.length){

            if ((right + 1) < nums.length && sum < s){
                //如果和小于s,就移动right,left保持不变
                sum += nums[right + 1];
                right++;
            }else {
                //如果和 大于等于s,就移动left;
                sum -= nums[left];
                left++;
            }

            if (sum >= s){
                res = Math.min(res,right - left + 1);
            }

        }
        if (res == nums.length + 1){
            return 0;
        }
        return res;
    }

    /**
     * 暴力解法
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int res = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        for (i = 0 ; i < nums.length ;i++){
            for (j = i + 1; j < nums.length ;j++){
                sum += nums[j];
                if (sum >= s){
                    if (res > j - i + 1){
                        res = j - i + 1;
                    }
                }
            }
        }
        return res;
    }

}

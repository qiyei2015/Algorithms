package com.leetcode.search;

import java.util.HashMap;

/**
 * @author Created by qiyei2015 on 2018/5/29.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 1. 两数之和
 */
public class TwoSum {

    /**
     * 使用map来记录值与索引 O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        int[] index = new int[2];

        HashMap<Integer,Integer> record = new HashMap<>();
        for (int i = 0 ;i < nums.length ;i++){
            //有找到索引
            if (record.get(target - nums[i]) != null){
                index[0] = Math.min(i,record.get(target - nums[i]));
                index[1] = Math.max(i,record.get(target - nums[i]));
                return index;
            }
            record.put(nums[i],i);
        }
        return null;
    }

}

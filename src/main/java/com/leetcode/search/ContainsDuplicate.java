package com.leetcode.search;

import java.util.HashSet;

/**
 * @author Created by qiyei2015 on 2018/5/31.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 217. 存在重复元素
 */
public class ContainsDuplicate {

    /**
     * 使用set来
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> record = new HashSet<>();
        for (int i = 0 ;i < nums.length ;i++){
            if (record.contains(nums[i])){
                return true;
            }
            record.add(nums[i]);
        }
        return false;
    }
}

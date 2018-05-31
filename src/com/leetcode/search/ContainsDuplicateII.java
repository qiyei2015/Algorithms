package com.leetcode.search;

import java.util.HashSet;

/**
 * @author Created by qiyei2015 on 2018/5/31.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 219. 存在重复元素 II
 */
public class ContainsDuplicateII {

    /**
     * 使用大小为k的滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //保证最多有k个元素
        HashSet<Integer> record = new HashSet<>();

        for (int i = 0 ;i < nums.length ;i++){

            //找到了
            if (record.contains(nums[i])){
                return true;
            }
            record.add(nums[i]);
            //保证最多有k个元素
            if (record.size() == k + 1){
                //删除最左边的元素 0 1 2 。。。。 k (k + 1)
                // 当i = k 共有 k + 1个元素，删除k
                record.remove(nums[i - k]);
            }
        }
        return false;
    }


}

package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2020/2/20.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 35. 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums,target,0,nums.length -1);
    }

    private int searchInsert(int[] nums, int target,int left,int right){
        if (left > right){
            return left;
        }

        int mid = left + (right - left) / 2;
        if (target == nums[mid]){
            return mid;
        } else if (target > nums[mid]){
            return searchInsert(nums,target,mid + 1,right);
        } else {
            return searchInsert(nums,target,left,mid - 1);
        }
    }
}

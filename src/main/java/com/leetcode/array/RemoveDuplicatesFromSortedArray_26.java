package com.leetcode.array;

import java.util.Arrays;

/**
 * @author Created by qiyei2015 on 2020/1/12.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 26
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray_26 {


    public static void main(String[] args) {
        int[] array = new int[]{0,0,1,1,1,2,2,3,3,4};

        System.out.println(new RemoveDuplicatesFromSortedArray_26().removeDuplicates(array));
        System.out.println(Arrays.toString(array));

    }


    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        //[0..k]记录删除重复元素后的数组,数组为0，没有重复元素
        int k = 0;
        for (int i = 1 ;i < nums.length ;i++){
            //元素不重复时,并且没有移动到num[k-1]中，就赋值
            if (nums[i] != nums[k]){
                swap(nums,i,k+1);
                k++;
            }
        }
        return k+1;
    }

    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

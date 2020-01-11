package com.leetcode.array;

import com.backup.backup.array.ArrayUtil;

/**
 * @author Created by qiyei2015 on 2018/5/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 75 sort colors
 */
public class SortColors {

    /**
     * 计数排序
     * @param nums
     */
    public void sortColors(int[] nums) {
        int[] counts = new int[3];

        for (int i = 0 ; i < nums.length ;i++){
            counts[nums[i]]++;
        }
        int k = 0;
        for (int i = 0; i < counts.length ;i++){
            for (int j = 0; j < counts[i] ; j++){
                nums[k] = i;
                k++;
            }
        }
    }

    /**
     * 三路快排应用 只有三个数
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int zero = -1; //a[0..zero] = 0
        int two = nums.length;//a[two..n-1] = 2;
        int i = 0; //a[zero+1 .. i-1] = 1
        int value = 1;

        //当i碰到two时就处理完了，不需要再继续处理
        for (i = 0 ;i < two;i++){
            //小于value，与zero + 1交换，并且zero++
            if (nums[i] < value){
                ArrayUtil.exch(nums,i,zero + 1);
                zero++;
            }else if (nums[i] > value){
                //大于value，与two - 1交换，并且two--
                ArrayUtil.exch(nums,i,two - 1);
                two--;
                //因为后面要++
                i--;
            }
        }
    }

}

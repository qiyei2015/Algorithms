package com.leetcode.array;

import java.util.Arrays;

/**
 * @author Created by qiyei2015 on 2020/1/12.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArray_88 {


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        new MergeSortedArray_88().merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }


    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     *
     * 说明:
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     *
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //先右移nums1 n位
        for (int i = m-1 ;i >= 0;i--){
            nums1[i + n] = nums1[i];
        }
        System.out.println(Arrays.toString(nums1));

        //nums1 索引
        int j = n;

        //nums2索引
        int k = 0;

        //考察的索引
        int i = 0;

        while (i < (m + n)){
            if (k >= n){
                //nums取完了
                //num2取完了
                nums1[i] = nums1[j];
                j++;
            } else if (j >= (m + n)){
                //nums1取完了
                nums1[i] = nums2[k];
                k++;
            } else if (nums1[j] < nums2[k]){
                nums1[i] = nums1[j];
                j++;
            } else if (nums1[j] > nums2[k]){
                nums1[i] = nums2[k];
                k++;
            } else if (nums1[j] == nums2[k]){
                nums1[i] = nums2[k];
                k++;
                i++;
                nums1[i] = nums1[j];
                j++;
            }
            i++;
        }
    }

}

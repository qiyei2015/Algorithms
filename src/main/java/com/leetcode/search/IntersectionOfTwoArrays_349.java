package com.leetcode.search;

import java.util.HashSet;

/**
 * @author Created by qiyei2015 on 2018/5/28.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 349 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays_349 {


    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> list = new HashSet<>();
        for (int i = 0 ;i < nums1.length ;i++){
            hashSet.add(nums1[i]);
        }

        for (int i = 0 ;i < nums2.length ;i++){
            if (hashSet.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }
        int[] array = new int[list.size()];
        int i = 0;
        for (Integer e: list){
            array[i] = e;
            i++;
        }
        return array;
    }

}

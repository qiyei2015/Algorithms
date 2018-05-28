package com.leetcode.search;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Created by qiyei2015 on 2018/5/28.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 350. 两个数组的交集 II
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        //记录数据出现的频率
        HashMap<Integer,Integer> record = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0 ;i < nums1.length ;i++){
            Integer value = record.get(nums1[i]);
            if (value == null){
                value = 0;
            }
            value++;
            record.put(nums1[i],value);
        }

        for (int i = 0 ;i < nums2.length ;i++){
            Integer value = record.get(nums2[i]);
            if (value != null && value > 0){
                list.add(nums2[i]);
                //更新Value值
                value--;
                record.put(nums2[i],value);
            }
        }

        int[] array = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++){
            array[i] = list.get(i);
        }
        return array;
    }

}

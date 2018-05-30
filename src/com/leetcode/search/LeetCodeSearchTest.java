package com.leetcode.search;

import com.qiyei.util.LogUtil;

import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/5/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LeetCodeSearchTest {

    public static void main(String[] args){
        testThreeSum();
    }


    private static void testThreeSum(){
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = new ThreeSum().threeSum(nums);
        LogUtil.println(list.toString());
     }

}

package com.leetcode.search;

import com.backup.backup.util.LogUtil;

import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/5/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LeetCodeSearchTest {

    public static void main(String[] args){
//        testThreeSum();
        testNumberOfBoomerangs();
    }


    private static void testThreeSum(){
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = new ThreeSum().threeSum(nums);
        LogUtil.println(list.toString());
     }

    private static void testNumberOfBoomerangs(){
        int[][] nums = new int[][]{{0,0},{1,0},{2,0}};
        int res = new NumberOfBoomerangs().numberOfBoomerangs(nums);
        LogUtil.println("res:" + res);
    }
}

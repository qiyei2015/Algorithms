package com.leetcode.search;

import java.util.HashMap;

/**
 * @author Created by qiyei2015 on 2018/5/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 454 四数相加 II
 * https://leetcode-cn.com/problems/4sum-ii/
 */
public class FourSumII_454 {

    /**
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //记录A+B中 key freq出现的pinglv
        HashMap<Integer,Integer> record1 = new HashMap<>();

        for (int i = 0 ;i < A.length ;i++){
            for (int j = 0 ;j < B.length ;j++){
                int key = A[i] + B[j];
                Integer value = record1.get(key);
                if (value == null){
                    value = 0;
                }
                value++;
                record1.put(key,value);
            }
        }

        int res = 0;
        for (int i = 0 ;i < C.length ;i++){
            for (int j = 0 ;j < D.length ;j++){
                int key = C[i] + D[j];
                if (record1.get(0 - key) != null){
                    res += record1.get(0 - key);
                }
            }
        }
        return res;
    }



}

package com.leetcode.dynamicprogramming;

/**
 * @author Created by qiyei2015 on 2020/1/18.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class PerfectSquares_279 {

    //记录n的最少完全平方数个数
    int[] memo;

    /**
     * 动态规划解法
     * @param n
     * @return
     */
    public int numSquares(int n) {
        memo = new int[n+1];
        for (int i = 0 ;i < memo.length ;i++){
            memo[i] = Integer.MAX_VALUE;
        }

        memo[0] = 0;
        memo[1] = 1;

        //对于每一个小于n的数都进行计算
        for (int i = 2; i <= n ;i++){
            //对每一个i进行拆分成完全平方数之和，求最小的
            //对于i来说一共有 i从1 2 3 。。 j*j <= i 种拆分
            for (int j = 1; j*j <= i ;j++){
                memo[i] = Math.min(memo[i],1 + memo[i - j * j]);
            }
        }

        return memo[n];
    }

    public int numSquares2(int n) {
        memo = new int[n+1];
        for (int i = 0 ;i < memo.length ;i++){
            memo[i] = Integer.MAX_VALUE;
        }
        return countNumSquares(n);

    }

    /**
     * 计算n的最小完全平方数个数,递归实现
     *
     * @param n
     * @return
     */
    private int countNumSquares(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (memo[n] != Integer.MAX_VALUE){
            return memo[n];
        }

        //一共有2 ..3 ..i种，其中每一种要求i*i <= n
        for (int i = 1; i * i <= n; i++){
            memo[n] = Math.min(memo[n],1 + countNumSquares(n - i * i));
        }

        return memo[n];
    }

}

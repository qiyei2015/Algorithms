package com.leetcode.dynamicprogramming;

/**
 * @author Created by qiyei2015 on 2020/1/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: https://leetcode-cn.com/problems/climbing-stairs/submissions/
 * 70. 爬楼梯
 */
public class ClimbingStairs_70 {

    private int[] memo;

    /**
     * 爬n阶台阶有多少种方法
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        memo = new int[n+1];

        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2 ;i <= n;i++){
            memo[i] = memo[i -1] + memo[i -2];
        }
        return memo[n];
    }

    public int climbStairs2(int n) {
        memo = new int[n+1];
        return calcWays(n);
    }

    private int calcWays(int n){
        //有一种
        if (n == 1){
            return 1;
        }
        //有两种
        if (n == 2){
            return 2;
        }

        if (memo[n] == 0){
            memo[n] = calcWays(n-1) + calcWays(n-2);
        }
        return memo[n];
    }
}

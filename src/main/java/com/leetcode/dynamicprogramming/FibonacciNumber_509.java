package com.leetcode.dynamicprogramming;

/**
 * @author Created by qiyei2015 on 2020/1/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class FibonacciNumber_509 {

    private int[] memo = new int[31];

    /**
     * 使用记忆化搜索
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 0){
            memo[0] = 0;
            return 0;
        }
        if (N == 1){
            memo[1] = 1;
            return 1;
        }

        if (memo[N] == 0){
            memo[N] = fib(N - 1) + fib(N - 2);
        }
        return memo[N];
    }

}

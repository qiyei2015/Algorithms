package com.leetcode.dynamicprogramming;

/**
 * @author Created by qiyei2015 on 2020/1/18.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 343. 整数拆分
 * https://leetcode-cn.com/problems/integer-break/
 */
public class IntegerBreak_343 {

    int[] memo;

    /**
     * 动态规划解法
     * 返回拆分为至少两个正整数的和，并使这些整数的乘积最大化的结果
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n;i++){
            //对于每一个i进行拆分,拆分为 j 和(i-j)
            for (int j = 1; j <= i -1 ;j++){
                //分为三部分，自身，j * (i - j),以及i-j的拆分 j * memo[i-j]
                memo[i] = max(memo[i],j * (i - j),j * memo[i - j]);
            }
        }
        return memo[n];
    }


    /**
     * 递归解法
     * @param n
     * @return
     */
    public int integerBreak2(int n) {
        memo = new int[n+1];
        return breakInteger(n);
    }

    /**
     * 分割n的最大乘机，至少分割两部分
     * @param n
     * @return
     */
    private int breakInteger(int n){
        if (n == 1){
            return 1;
        }
        int res = -1;
        if (memo[n] != 0){
            return memo[n];
        }
        for (int i = 1;i <= n - 1;i++){
            res = max(res,i * (n-i),i * breakInteger(n -i));
            memo[n] = res;
        }
        return res;
    }

    private int max(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }
}

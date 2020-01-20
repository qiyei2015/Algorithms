package com.leetcode.dynamicprogramming;

/**
 * @author Created by qiyei2015 on 2020/1/20.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 0 1 背包问题
 *
 */
public class Knapsack01 {

    //记录[i][c]处的元素是否计算过
    int[][] memo;


    /**
     * n个元素放进容量为C中，总价值最大
     * @param w 每个元素的重量
     * @param v 每个元素的价值
     * @param C 背包容量
     * @return 返回总价值
     */
    public int knapsack01(int[] w,int[] v,int C) {
        if (w == null || v == null || w.length != v.length || w.length == 0){
            return 0;
        }
        int n = w.length - 1;
        //记录的是memo[i][j]，其中i表示第i个元素放进容量为j的背包的总价值大小
        memo = new int[n][C+1];

        //先考虑第1个元素w[0] 放进容量为[0...j]的背包
        for (int j = 0 ;j <= C;j++){
            memo[0][j] = (j >= w[0] ? v[0] : 0);
        }

        for (int i = 1; i < n; i++){
            for (int j = 0;j <= C;j++){
                //先考虑不放进第i个个元素
                memo[i][j] = memo[i-1][j];
                //考虑放进第i个元素，并且取最大值
                if (j >= w[i]){
                    memo[i][j] = Math.max(memo[i][j],v[i] + memo[i -1][j - w[i]]);
                }
            }
        }
        //返回n-1个元素放进C中
        return memo[n-1][C];
    }

    /**
     * n个元素放进容量为C中，总价值最大
     * @param w 每个元素的重量
     * @param v 每个元素的价值
     * @param C 背包容量
     * @return 返回总价值
     */
    public int knapsack01_2(int[] w,int[] v,int C) {
        int n = w.length - 1;
        memo = new int[n][C+1];
        for (int i = 0; i < memo.length;i++){
            for (int j = 0 ;j < memo[i].length ;j++){
                memo[i][j] = -1;
            }
        }
        return bestValue(w,v,n,C);
    }

    /**
     * 考虑[0...index]这个范围内，容量为c的背包能放进的总价值是多少
     * @param w
     * @param v
     * @param index
     * @param c
     * @return
     */
    private int bestValue(int[] w,int[] v,int index,int c){
        //无法放进任何元素了
        if (index < 0 || c < 0){
            return 0;
        }

        if (memo[index][c] != -1){
            return memo[index][c];
        }

        //不放进index处的元素
        int res = bestValue(w,v,index - 1,c);
        //放进index处的元素，并取最大值
        if (c >= w[index]){
            res = Math.max(res,v[index -1] + bestValue(w,v,index - 1,c - w[index]));
        }
        memo[index][c] = res;
        return res;
    }
}

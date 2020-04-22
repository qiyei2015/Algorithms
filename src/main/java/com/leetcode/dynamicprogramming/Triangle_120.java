package com.leetcode.dynamicprogramming;

import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/1/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 */
public class Triangle_120 {

    private int[][] memo;


    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new int[triangle.size()][triangle.size()];

        // dp[i,j] = min(Cij + dp[i][j+1],Cij + dp[i+1][j+1])
        for (int i = triangle.get(triangle.size() - 1).size() - 1; i >= 0; i--) {
            memo[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                memo[i][j] = Math.min(triangle.get(i).get(j) + memo[i + 1][j], triangle.get(i).get(j) + memo[i + 1][j + 1]);
            }
        }
        return memo[0][0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int[][] memo2 = new int[2][triangle.get(triangle.size() - 1).size()];

        // dp[i,j] = min(Cij + dp[i][j+1],Cij + dp[i+1][j+1])
        for (int i = triangle.get(triangle.size() - 1).size() - 1; i >= 0; i--) {
            memo2[(triangle.size() - 1) % 2][i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                memo2[i % 2][j] = Math.min(triangle.get(i).get(j) + memo2[(i + 1) % 2][j], triangle.get(i).get(j) + memo2[(i + 1) % 2][j + 1]);
            }
        }
        return memo2[0][0];
    }
}

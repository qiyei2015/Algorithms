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

    private MinRes[] memo;

    private static class MinRes{
        int sum;
        int index;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        //size 行
        memo = new MinRes[triangle.size()];
        for (int i = 0 ;i < memo.length ;i++){
            memo[i] = new MinRes();
        }

        if (triangle.size() == 1){
            memo[0] = min(triangle.get(0),0,0);
            return memo[0].sum;
        }

        memo[0] = min(triangle.get(0),0,0);
        MinRes r = min(triangle.get(1),Math.max(0,memo[0].index - 1),Math.min(memo[0].index + 1,triangle.get(1).size() - 1));
        memo[1].sum = memo[0].sum + r.sum;
        memo[1].index = r.index;

        for (int i = 2 ;i < triangle.size() ;i++){
            MinRes res = min(triangle.get(i),Math.max(0,memo[i-1].index - 1),Math.min(memo[i-1].index + 1,triangle.get(i).size() - 1));
            memo[i].sum = memo[i -1].sum + res.sum;
            memo[i].index = res.index;
        }
        return memo[triangle.size() - 1].sum;

    }


    private MinRes min(List<Integer> list,int start,int end){
        MinRes res = new MinRes();
        res.sum = list.get(start);
        res.index = start;
        for (int i = start ;i <= end ;i++){
            if (res.sum > list.get(i)){
                res.sum = list.get(i);
                res.index = i;
            }
        }
        return res;
    }
}

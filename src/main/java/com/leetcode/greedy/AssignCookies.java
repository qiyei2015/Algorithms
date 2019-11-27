package com.leetcode.greedy;

import java.util.Arrays;

/**
 * @author Created by qiyei2015 on 2018/6/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 455. 分发饼干
 */
public class AssignCookies {

    /**
     * 贪心算法 时间复杂度 O(n*log n)
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int si = s.length - 1;
        int gi = g.length - 1;
        int res = 0;

        while (gi >= 0 && si >= 0){
            if (s[si] >= g[gi]){
                //可以分配
                si--;
                gi--;
                res++;
            }else {
                //不能分配，考虑下一个g[i]的小朋友
                gi--;
            }
        }

        return res;
    }

}

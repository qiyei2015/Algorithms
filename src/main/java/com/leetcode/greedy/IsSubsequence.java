package com.leetcode.greedy;

/**
 * @author Created by qiyei2015 on 2018/6/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 392 判断子序列
 */
public class IsSubsequence {

    /**
     * 判断s是否是t的子序列
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int si = 0;
        int ti = 0;

        while (si < s.length() && ti < t.length()){
            if (s.charAt(si) == t.charAt(ti)){
                si++;
                ti++;
            }else {
                ti++;
            }
        }

        if (si == s.length()){
            //是子序列
            return true;
        }
        return false;
    }


}

package com.leetcode.string;

/**
 * @author Created by qiyei2015 on 2020/2/19.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class ImplementStrstr_28 {


    public int strStr(String haystack, String needle) {
        if (needle == null || needle.trim().equals("")){
            return 0;
        }
        if (haystack == null || haystack.trim().equals("")){
            return -1;
        }

        int j = 0;
        int i = 0;
        int index = -1;

        while (i < haystack.length()){
            if (j < needle.length() && haystack.charAt(i) == needle.charAt(j)){
                if (j == 0){
                    index = i;
                }
                j++;
                if (j == needle.length()){
                    return index;
                }
            } else if (haystack.charAt(i) != needle.charAt(j) && j > 0){
                j = 0;
                i = index;
                index = -1;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementStrstr_28().strStr("mississippi","issip"));
    }
}

package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 76
 */
public class MinimumWindowSubstring {


    /**
     * s 中包含t 的最小子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        List<Integer> list = new ArrayList<>();

        char[] array = s.toCharArray();

        int left = 0;
        int right = t.length() - 1;// [left..right] 初始化长度为p的长度

        int min = s.length() + 1;

        while (left < array.length && right < array.length){

            //如果包含
            if (minWindow(array,left,right,t)){
                if (min > right - left + 1){
                    list.add(left);
                    list.add(right);
                }

                left++;
            }else {
                right ++;
            }
        }
        if (min == array.length + 1){
            return null;
        }
        return s.substring(left,right);
    }

    /**
     * 包含字符串t
     * @param array
     * @param left
     * @param right
     * @param t
     * @return
     */
    private boolean minWindow(char[] array, int left, int right, String t) {

        return true;
    }


}

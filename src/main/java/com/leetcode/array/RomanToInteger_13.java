package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2020/2/18.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 13. 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class RomanToInteger_13 {

    public int romanToInt(String s) {
        int sum = 0;
        if (s == null || s.length() <= 0) {
            return sum;
        }
        int prev = getValue(s.charAt(0));
        for (int i = 1; i < s.length() ;i++) {
            int cur = getValue(s.charAt(i));
            if (prev < cur) {
                sum -= prev;
            } else {
                sum += prev;
            }
            prev = cur;
        }
        sum += prev;
        return sum;
    }

    private int getValue(char s){
        switch (s){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

package com.leetcode.array;

import com.qiyei.util.LogUtil;

/**
 * @author Created by qiyei2015 on 2018/5/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LeetCodeArrayTest {

    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        String s6 = "hello";

        LogUtil.println("" + new ValidPalindrome().isPalindrome(s));
        LogUtil.println("" + new ValidPalindrome().isPalindrome(s1));

        LogUtil.println("" + new ReverseString().reverseString(s6));
    }

}

package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2020/2/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class PalindromeNumber_9 {

    /**
     * 字符串方案一
     * 反转一半 方案二
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        return x == reverse(x);
    }

    /**
     * 子过程
     * @param x
     * @return
     */
    private int reverse(int x) {
        int res = 0;
        while (x !=0){
            //先乘以10，再除以10,不等就溢出了
            if ((res * 10) / 10 != res){
                res = 0;
                break;
            }
            res = res * 10 + (x % 10);
            x = x / 10;
        }
        return res;
    }

}

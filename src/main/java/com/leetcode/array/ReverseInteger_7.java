package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2020/2/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 7. 整数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class ReverseInteger_7 {

    public int reverse(int x) {
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

package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2020/2/21.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class Sqrtx_69 {

    public int mySqrt(int x) {
        if (x < 2){
            return x;
        }

        int left = 2;
        int right = x / 2;
        long num;
        while (left <= right){
            int mid = left + (right - left)/2;
            //需要先把一个数转为long,否则会溢出
            num = (long)mid * mid;
            if (num > x){
                right = mid - 1;
            } else if (num < x){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        //返回最后一个值
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrtx_69().mySqrt(2147395599));
    }
}

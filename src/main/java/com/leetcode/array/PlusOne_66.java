package com.leetcode.array;

import java.util.Arrays;

/**
 * @author Created by qiyei2015 on 2020/2/20.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 66. 加一
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne_66 {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne_66().plusOne(new int[]{1,2,3})));
    }
}

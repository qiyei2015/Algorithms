package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2020/2/6.
 * @version: 1.0 <br>
 * @email: 1273482124@qq.com
 * @description: 67. 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 */
public class AddBinary_67 {



    public String addBinary(String a, String b) {
        int sum = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        //记录结果
        String res = "";
        while (i >= 0 || j >= 0){
            if (i >= 0){
                sum += Integer.parseInt(String.valueOf(a.charAt(i)));
                i--;
            }
            if (j >= 0){
                sum += Integer.parseInt(String.valueOf(b.charAt(j)));
                j--;
            }
            //对sum取余
            res = sum % 2 + res;
            //进位
            sum = sum / 2;
        }

        if (sum % 2 != 0){
            res = sum % 2 + res;
        }

        return res;
    }


    public static void main(String[] args) {


        System.out.println(new AddBinary_67().addBinary("1010","1011"));

    }
}

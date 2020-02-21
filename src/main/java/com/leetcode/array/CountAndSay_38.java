package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2020/2/20.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 38. 外观数列
 * https://leetcode-cn.com/problems/count-and-say/
 */
public class CountAndSay_38 {

    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        String s = countAndSay(n-1);
        //多添加一个整数
        s += "A";
        StringBuilder builder = new StringBuilder();
        int i = 0;
        int j = i;
        for(i = 0;i < s.length() - 1;i++){
            if (s.charAt(i) != s.charAt(i+1)){
                builder.append((i-j+1)).append(s.charAt(i));
                j = i + 1;
            }
        }
        return builder.toString();
    }

}

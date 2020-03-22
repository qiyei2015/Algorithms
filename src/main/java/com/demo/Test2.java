package com.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Created by qiyei2015 on 2020/2/7.
 * @version: 1.0 <br>
 * @email: 1273482124@qq.com
 * @description:
 */
public class Test2 {


    class Node {
        Map<String,String> map;
        Map<String,Map<String,String>> map2;

        public String getValue(String key){
            return map.get(key);
        }

        public Map<String,String> getValue2(String key){
            return map2.get(key);
        }
    }


    public  Node parse(String s){
        if (s == null || s.length() == 0){
            return null;
        }
        char[] strArr = s.toCharArray();
        Map<String,String> map = new HashMap<>();

        //需要使用栈来记录{
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ;i < s.length() ;i++) {
            stack.push(strArr[i]);

            if (strArr[i] == ',') {
                //出栈，分别记录key value
            }

            //遇到{ 使用递归方式来遍历

        }

        return null;
    }
}

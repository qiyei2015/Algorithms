package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/6/9.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 17. 电话号码的字母组合
 */
public class LetterCombinationsOfAPhoneNumber {

    private List<String> list = new ArrayList<>();

    private String[] letterMap = new String[]{
            " "
            ,""
            ,"abc"
            ,"def"
            ,"ghi"
            ,"jkl"
            ,"mno"
            ,"pqrs"
            ,"tuv"
            ,"wxyz"};

    /**
     * 递归调用
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        list.clear();
        if (digits == null){
            return list;
        }
        if (digits.equals("")){
            return list;
        }
        findCombinations(digits,0,"");
        return list;
    }

    /**
     * 在digits中找到从index开始的字符串
     * @param digits 原始字符串
     * @param index
     * @param res 0 -- index-1中的字符串
     */
    private void findCombinations(String digits,int index,String res){
        //递归结束条件
        if (index == digits.length()){
            //保存res
            list.add(res);
            return;
        }

        char c = digits.charAt(index);
        if (c >= '2' && c <= '9'){
            String letters = letterMap[c - '0'];
            for (int i = 0 ;i < letters.length() ;i++){
                //递归调用
                findCombinations(digits,index + 1,res + letters.charAt(i));
            }
        }
    }
}

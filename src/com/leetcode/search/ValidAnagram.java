package com.leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by qiyei2015 on 2018/5/29.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:  242. 有效的字母异位词
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        HashMap<Character,Integer> record = new HashMap<>();
        char[] arrar1 = s.toCharArray();
        //记录出现的频率 key 为字符串，value为出现的频率
        for (int i = 0 ; i < arrar1.length;i++){
            Integer value = record.get(arrar1[i]);
            if (value == null){
                value = 0;
            }
            value++;
            record.put(arrar1[i],value);
        }

        char[] arrar2 = t.toCharArray();
        //记录出现的频率
        for (int i = 0 ; i < arrar2.length;i++){
            //清理
            Integer value = record.get(arrar2[i]);
            if (value == null){
                return false;
            }
            value--;
            record.put(arrar2[i],value);
        }

        //判断是否清理干净
        for (Map.Entry<Character,Integer> entry : record.entrySet()){
            if (entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }

}

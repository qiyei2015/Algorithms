package com.leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by qiyei2015 on 2018/5/31.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 447. 回旋镖的数量
 */
public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0 ;i < points.length ;i++){

            //记录距离 频率
            HashMap<Integer,Integer> record = new HashMap<>();

            for (int j = 0 ;j < points.length ;j++){
                if (i != j){
                    int key = dis(points[i],points[j]);
                    if (record.containsKey(key)){
                        record.put(key,record.get(key) + 1);
                    }else {
                        record.put(key,1);
                    }
                }
            }

            //遍历频率大于2 的结果
            for (Map.Entry<Integer,Integer> entry : record.entrySet()){
                if (entry.getValue() != 0 && entry.getValue() >= 2){
                    res += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }

        return res;
    }

    /**
     * 计算两点之间距离
     * @param point
     * @param point1
     * @return
     */
    private int dis(int[] point, int[] point1) {
        int x = Math.abs(point[0] - point1[0]);
        int y = Math.abs(point[1] - point1[1]);
        return x*x + y*y;
    }

}

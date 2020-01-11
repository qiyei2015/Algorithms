package com.backup.backup.p001;

import com.qiyei.algorithms.search.BinarySearch;

import java.util.Arrays;

/**
 * @author Created by qiyei2015 on 2018/3/12.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 找出一个数组中3个和为0的个数
 */
public class ThreeSum {


    /**
     * 最笨的办法，三次循环 时间复杂度 n^3
     * @param array
     * @return
     */
    public static int count1(int[] array){
        int cnt = 0;
        for (int i = 0 ;i < array.length ; i++){
            for (int j = i + 1 ; j < array.length; j++){
                for (int k = j + 1; k < array.length ; k++){
                    if (array[i] + array[j] + array[k] == 0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    /**
     * 最笨的办法，2次循环 时间复杂度 n^2 * LogN
     * @param array
     * @return
     */
    public static int count2(int[] array){

        //归并排序 复杂度 N*LogN
        Arrays.sort(array);

        int cnt = 0;
        for (int i = 0 ;i < array.length ; i++){
            for (int j = i + 1 ; j < array.length; j++){
                if (BinarySearch.search(-(array[i] + array[j]),array) > j){
                    cnt++;
                }
            }
        }
        return cnt;
    }

}

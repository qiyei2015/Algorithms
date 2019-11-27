package com.qiyei.p001;

import java.util.Arrays;

/**
 * @author Created by qiyei2015 on 2018/3/12.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 找出一个数组中2个和为0的个数
 */
public class TwoSum {

    /**
     * 最笨的办法，2次循环 时间复杂度 n^2
     * @param array
     * @return
     */
    public static int count1(int[] array){
        int cnt = 0;
        for (int i = 0 ;i < array.length ; i++){
            for (int j = i + 1 ; j < array.length; j++){
                if (array[i] + array[j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 先排序，再来遍历 时间复杂度N*LogN
     * @param array
     * @return
     */
    public static int count2(int[] array){
        int cnt = 0;
        //归并排序 复杂度 N*LogN
        Arrays.sort(array);

        //N*LogN
        for (int i = 0; i < array.length ; i++){
            //两个数和为0，互为相反数，因此在i处的相反数在数组中能找到，并且最终位置在数组的右半边，说明满足条件
            if (BinarySerach.rank(-array[i],array) > i){
                cnt++;
            }
        }
        return cnt;
    }

}

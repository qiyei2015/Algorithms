package com.qiyei.sort;

/**
 * @author Created by qiyei2015 on 2018/3/14.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 选择排序
 */
public class SelectionSort extends BaseSort{

    /**
     * 依次从数组中选择最小的数排在最前面
     * @param array
     */
    @Override
    public void sort(Comparable[] array) {
        for (int i = 0 ; i < array.length ; i++){
            int min = i;
            for (int j = i + 1 ; j < array.length ; j++){
                //找到本次循环最小的数
                if (less(array[j],array[min])){
                    min = j;
                }
            }
            exch(array,i,min);
        }
    }

}

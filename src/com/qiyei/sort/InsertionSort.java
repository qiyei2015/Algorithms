package com.qiyei.sort;

/**
 * @author Created by qiyei2015 on 2018/3/15.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class InsertionSort extends BaseSort{


    /**
     * 插入排序，将a[i] 插入到a[0] ---- a[i-1]合适的位置中
     * @param array
     */
    @Override
    public void sort(Comparable[] array) {
        int length = array.length;
        for (int i = 1 ; i < length ; i++){
            //处理a[0] ---- a[i-1]数组
            for (int j = i ; j > 0 && less(array[j],array[j-1]); j--){
                exch(array,j,j-1);
            }
        }
    }



}

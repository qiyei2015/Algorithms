package com.qiyei.heap;

import com.qiyei.sort.BaseSort;

/**
 * @author Created by qiyei2015 on 2018/3/28.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 堆排序
 */
public class HeapSort extends BaseSort {

    /**
     * 堆排序
     * @param array
     */
    @Override
    public void sort(Comparable[] array) {
        MaxPQ<Integer> maxPQ = new MaxPQ(array.length);
        for (int i = 0 ; i < array.length ; i++){
            maxPQ.insert((Integer) array[i]);
        }
        for (int i = array.length - 1 ; i >= 0 ; i--){
            array[i] = maxPQ.delMax();
        }
    }

    public void sort2(Comparable[] array) {
        MaxPQ maxPQ = new MaxPQ(array);
        for (int i = array.length - 1 ; i >= 0 ; i--){
            array[i] = maxPQ.delMax();
        }
    }
}

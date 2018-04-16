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

    /**
     * 使用最小堆排序
     * @param array
     */
    public void sort3(Comparable[] array){
        MinPQ<Integer> minPQ = new MinPQ(array.length);
        for (int i = 0 ; i < array.length ; i++){
            minPQ.insert((Integer) array[i]);
        }
        for (int i = 0 ; i < array.length; i++){
            array[i] = minPQ.delMin();
        }
    }


    /**
     * 使用最小堆排序
     * @param array
     */
    public void sort4(Comparable[] array){
        MinPQ<Integer> minPQ = new MinPQ(array);
        for (int i = 0 ; i < array.length; i++){
            array[i] = minPQ.delMin();
        }
    }

}

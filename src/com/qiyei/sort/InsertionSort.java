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
            //处理a[0] ---- a[i-1]数组,找到a[i]可以插入的位置
            for (int j = i ; j > 0 && less(array[j],array[j-1]); j--){
                exch(array,j,j-1);
            }
        }
    }

    /**
     * 将数组lo 到hi之间快速排序
     * @param array
     * @param lo
     * @param hi
     */
    public void sort(Comparable[] array,int lo,int hi) {
        if (lo >= hi || array == null){
            return;
        }
        if (lo < 0 || hi >= array.length){
            return;
        }
        int length = array.length;
        for (int i = lo + 1 ; i <= hi ; i++){
            //处理a[lo] ---- a[i-1]数组,找到a[i]可以插入的位置
            for (int j = i ; j > lo && less(array[j],array[j-1]); j--){
                exch(array,j,j-1);
            }
        }
    }


    /**
     * 插入排序优化 少交换，不用每次都从j-1到i处交换，只用在前面找到合适的位置，最后赋值
     * @param array
     */
    public void sortOpt(Comparable[] array) {
        int length = array.length;
        for (int i = 1 ; i < length ; i++){
            int j = i;
            Comparable temp = array[i];
            //不用每次都交换，直接找到合适的位置，然后交换
            for (; j > 0 && less(temp,array[j-1]); j--){
                //后移一个位置
                array[j] = array[j-1];
            }
            //找到a[i]合适的位置j了
            array[j] = temp;
        }
    }

}

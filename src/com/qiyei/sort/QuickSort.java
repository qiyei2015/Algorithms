package com.qiyei.sort;

/**
 * @author Created by qiyei2015 on 2018/3/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class QuickSort extends BaseSort {


    @Override
    public void sort(Comparable[] array) {
        int lo = 0;
        int hi = array.length - 1;
        sort(array,lo,hi);
    }

    /**
     * 快速排序，分治
     * @param array
     * @param lo
     * @param hi
     */
    private void sort(Comparable[] array,int lo,int hi){
        //递归结束条件
        if (hi <= lo){
            return;
        }
        //parttion 已经处于该位置上的有序了，因此该位置上的数不用排序
        int parttion = parttion(array,lo,hi);
        sort(array,lo,parttion -1);
        sort(array,parttion + 1,hi);
    }

    /**
     * 找到切分点,将数组分为 a[lo,k-1] a[k] a[k+1,hi]三部分
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    private int parttion(Comparable[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = array[lo];
        while (true){

            //从左扫描，比较时候有大于v的数
            while (less(array[++i],v)){
                if (i == hi){
                    break;
                }
            }
            //
            while (less(v,array[--j])){
                if (j == lo){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            exch(array,i,j);
        }
        exch(array,lo,j);
        return j;
    }

}

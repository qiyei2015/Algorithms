package com.qiyei.sort;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/3/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class QuickSort extends BaseSort {

    private static final int M = 15;

    @Override
    public void sort(Comparable[] array) {
        int lo = 0;
        int hi = array.length - 1;
        sort(array,lo,hi);
    }

    /**
     * 双路快速排序
     * @param array
     */
    public void sortTwoWays(Comparable[] array) {
        int lo = 0;
        int hi = array.length - 1;
        sort2Ways(array,lo,hi);
    }

    /**
     * 3路快速排序
     * @param array
     */
    public void sortThreeWays(Comparable[] array) {
        int lo = 0;
        int hi = array.length - 1;
        sort3Ways(array,lo,hi);
    }

    /**
     * 快速排序，分治 递归
     * @param array
     * @param lo
     * @param hi
     */
    private void sort(Comparable[] array,int lo,int hi){
        //递归结束条件
        if (hi - lo <= M){
            //优化2 使用插入排序
            new InsertionSort().sort(array,lo,hi);
            return;
        }
        //parttion 已经处于该位置上的有序了，因此该位置上的数不用排序
        int parttion = parttion2(array,lo,hi);
        sort(array,lo,parttion -1);
        sort(array,parttion + 1,hi);
    }

    /**
     * 快速排序，分治递归
     * @param array
     * @param lo
     * @param hi
     */
    private void sort2Ways(Comparable[] array,int lo,int hi){
        //递归结束条件
        if (hi - lo <= M){
            //优化2 使用插入排序
            new InsertionSort().sort(array,lo,hi);
            return;
        }
        //parttion 已经处于该位置上的有序了，因此该位置上的数不用排序
        int parttion = parttion3(array,lo,hi);
        sort(array,lo,parttion -1);
        sort(array,parttion + 1,hi);
    }


    /**
     * 快速排序，分治递归
     * @param array
     * @param lo
     * @param hi
     */
    private void sort3Ways(Comparable[] array,int lo,int hi){
        //递归结束条件
        if (hi - lo <= M){
            //优化2 使用插入排序
            new InsertionSort().sort(array,lo,hi);
            return;
        }
        //优化1 将a[lo]随机化，防止对有序的数组太慢
        int k = lo + new Random().nextInt(hi-lo);
        exch(array,lo,k);

        Comparable v = array[lo];

        //a[lo+1..lt] < v a[lt+1..i) = v a[gt..hi] > v
        int lt = lo;
        int gt = hi + 1;
        int i = lo + 1;

        while (i < gt){
            if (less(v,array[i])){
                exch(array,gt-1,i);
                gt--;
                //i指向的元素没有被处理，不需要增加
            }else if (less(array[i],v)){
                //交换a[lo+1...lt] < v
                exch(array,lt+1,i);
                i++;
                lt++;
            }else {
                i++;
            }
        }
        exch(array,lo,lt);

        sort3Ways(array,lo,lt - 1);
        sort3Ways(array,gt,hi);
    }


    /**
     * 找到切分点,将数组分为 a[lo,k-1] a[k] a[k+1,hi]三部分,其中a[lo..k-1] < a[k],a[k+1..hi] > a[k]
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    private int parttion(Comparable[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = array[lo];
        //a[lo+1..k-1] < a[k],a[k+1..hi] > a[k]
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

    /**
     * 找到切分点,将数组分为 a[lo,j-1] a[j] a[j+1,hi]三部分,其中a[lo..j-1] < a[j],a[j+1..hi] > a[j]
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    private int parttion2(Comparable[] array, int lo, int hi){
        //优化1 将a[lo]随机化，防止对有序的数组太慢
        int k = lo + new Random().nextInt(hi-lo);
        exch(array,lo,k);

        Comparable v = array[lo];
        int j = lo;
        //找到切分点 a[lo..j-1] < a[j],a[j+1..hi] > a[j]
        for (int i = lo + 1; i <= hi ;i++){
            //如果a[i]比v大，就交换j+1和i,并且j++
            if (less(array[i],v)){
                exch(array,j + 1,i);
                j++;
            }
        }
        exch(array,lo,j);
        return j;
    }


    /**
     * 找到切分点,将数组分为 a[lo,j-1] a[j] a[j+1,hi]三部分,其中a[lo..j-1] < a[j],a[j+1..hi] > a[j]
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    private int parttion3(Comparable[] array, int lo, int hi){
        //优化1 将a[lo]随机化，防止对有序的数组太慢
        int k = lo + new Random().nextInt(hi-lo);
        exch(array,lo,k);

        Comparable v = array[lo];
        //(
        int i = lo + 1;
        int j = hi;
        //找到切分点 a[lo..i) <= v,a(j..hi] => v
        while (true){
            while (i <= hi && less(array[i],v)){
                i++;
            }
            while (j >= lo + 1 && less(v,array[j])){
                j--;
            }
            //循环结束
            if (i >= j){
                break;
            }
            //a[i] > v 且a[j] < v
            exch(array,i,j);
            i++;
            j--;
        }
        exch(array,lo,j);
        return j;
    }

}

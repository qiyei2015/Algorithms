package com.qiyei.algorithms.sort;

import java.util.Arrays;

/**
 * @author Created by qiyei2015 on 2019/12/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 归并排序，主要用到的思想是递归，分治
 * 将一个数组划分为2，再划分为4，。。。最后再对小数组排序，然后再归并
 */
public class MergeSort extends BaseSort{

    @Override
    protected String getTag() {
        return "MergeSort";
    }

    @Override
    public void sort(Comparable[] array) {
        super.sort(array);
        sort(array,0,array.length - 1);
    }

    /**
     * 自底向上归并
     * @param array
     */
    public void sortBU(Comparable[] array) {
        super.sort(array);
        //每次归并时的size，从1 开始逐步增加
        for (int size = 1; size <= array.length ; size += size){
            //对子数组a[i..i+ size-1] a[i+ size.. i + 2*size-1]进行归并，每个子数组的大小是size
            //array.length - size是因为最后的size个数据已经在前面被算过了
            for (int i = 0; i < array.length - size ;i += 2 * size){
                merge(array,i,i+ size - 1,Math.min( i + 2 * size - 1,array.length - 1));
            }
        }
    }

    /**
     * 对a[l...r]进行规避排序
     * @param array
     * @param l
     * @param r
     */
    private void sort(Comparable[] array, int l, int r) {
        if (l >= r){
            return;
        }
        //此处可以使用插入排序优化
//        if (r - l == 15){
//            new InsertSort().sort(array);
//        }
        int mid = l + (r - l) / 2;
        sort(array,l,mid);
        sort(array,mid + 1,r);
        //对结果进行归并,优化过后的结果
        if (array[mid].compareTo(array[mid + 1]) > 0){
            merge(array,l,mid,r);
        }
    }

    /**
     * 对a[l..mid] a[mid+1..r]进行归并
     * @param array
     * @param l
     * @param mid
     * @param r
     */
    private void merge(Comparable[] array, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(array,l,r + 1);
        int k = l;

        int i = l;
        int j = mid + 1;

        while (k <= r){
            if (i > mid){
                //a[l..mid]已经取完了
                array[k] = aux[j - l];
                j++;
            } else if (j > r){
                //a[mid+1..r]已经取完了
                array[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0){
                array[k] = aux[i - l];
                i++;
            } else {
                array[k] = aux[j - l];
                j++;
            }
            k++;
        }
    }


}

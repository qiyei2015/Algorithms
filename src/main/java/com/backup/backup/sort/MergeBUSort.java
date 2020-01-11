package com.backup.backup.sort;

/**
 * @author Created by qiyei2015 on 2018/3/19.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 归并排序，自底向上
 */
public class MergeBUSort extends BaseSort {

    private Comparable[] aux;

    @Override
    public void sort(Comparable[] array) {
        aux = new Comparable[array.length];
        int length = array.length;

        //第一个循环为子数组的大小
        for (int i = 1 ; i < length ; i *= 2) {
            //最后一个是 a[length - 1 - i] a[length-1] 大小为 i
            for (int j = 0; j < length - i; j += 2 * i) {
                //子数组序号为 j j+i-1 j+2*i-1 减1是因为i从1开始 n - j = i;
                merge(array,j,j + i - 1 ,Math.min((j + 2*i - 1),length - 1));
            }
        }
    }

    /** a[j] a[j+i]
     * 数组合并
     * @param array
     * @param lo
     * @param mid
     * @param hi
     */
    private void merge(Comparable[] array,int lo,int mid,int hi){
        int i = lo;
        int j = mid + 1;

        //将数组array复制到aux中
        for (int k = lo ;k <= hi ; k++){
            aux[k] = array[k];
        }

        //aux[lo..mid] aux[mid+1..hi]
        for (int k = lo ; k <= hi ; k++){
            if (i > mid){
                //i 超过mid，说明左半边用完，取右半边
                array[k] = aux[j++];
            }else if (j > hi){
                //j 超过hi，说明右半边用完，取左半边
                array[k] = aux[i++];

            }else if (less(aux[i],aux[j])){
                //i 比j小，取i
                array[k] = aux[i++];
            }else {
                array[k] = aux[j++];
            }
        }
    }
}

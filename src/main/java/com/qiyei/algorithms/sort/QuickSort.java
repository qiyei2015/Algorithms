package com.qiyei.algorithms.sort;

/**
 * @author Created by qiyei2015 on 2019/12/18.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 快速排序
 */
public class QuickSort extends BaseSort {


    @Override
    protected String getTag() {
        return "QuickSort";
    }

    @Override
    public void sort(Comparable[] array) {
        super.sort(array);
        quickSort(array,0,array.length - 1);
    }

    /**
     * 对a[l..r]进行快速排序
     * @param array
     * @param l
     * @param r
     */
    private void quickSort(Comparable[] array, int l, int r) {
        if (l >= r){
            return;
        }

        int p = partition(array,l,r);
        quickSort(array,l,p);
        quickSort(array,p+1,r);
    }

    /**
     * 对a[l...r]进行切分，使其a[l+1..j] < a[l] a[j+1..r] >= a[l]
     * @param array
     * @param l
     * @param r
     * @return
     */
    private int partition(Comparable[] array, int l, int r) {
        //1 优化1 随机化
        Comparable v = array[l];
        int j = l;
        for (int i = l+1; i <= r;i++){
            if (array[i].compareTo(v) < 0){
                swap(array,j + 1,i);
                j++;
            }
        }
        swap(array,l,j);
        return j;
    }


    public void sortTwoWays(Comparable[] array) {
        super.sort(array);
        quickSortTwoWays(array,0,array.length - 1);
    }

    /**
     * 对a[l..r]进行快速排序
     * @param array
     * @param l
     * @param r
     */
    private void quickSortTwoWays(Comparable[] array, int l, int r) {
        if (l >= r){
            return;
        }

        int p = partitionTwoWays(array,l,r);
        quickSortTwoWays(array,l,p);
        quickSortTwoWays(array,p+1,r);
    }

    /**
     * 对a[l...r]进行切分，使其a[l+1..i) <= a[l] a(j..r] >= a[l]
     * @param array
     * @param l
     * @param r
     * @return
     */
    private int partitionTwoWays(Comparable[] array, int l, int r) {
        //1 优化1 随机化
        Comparable v = array[l];

        int i = l+1;
        int j = r;
        while (true){

            //找到第一个大于等于v的索引
            while (i <= r && array[i].compareTo(v) < 0){
                i++;
            }

            //找到最后一个大于等于v的索引
            while (j >= l+1 && array[j].compareTo(v) > 0){
                j--;
            }

            //i与j汇合，循环结束
            if (i > j){
                break;
            }

            swap(array,i ,j);
            i++;
            j--;
        }
        swap(array,l,j);
        return j;
    }
}

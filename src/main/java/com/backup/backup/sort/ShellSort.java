package com.backup.backup.sort;

/**
 * @author Created by qiyei2015 on 2018/3/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class ShellSort extends BaseSort {


    @Override
    public void sort(Comparable[] array) {
        int length = array.length;
        int h = 0;

        /**
         * 递增序列 3*k + 1
         */
        while (h < length / 3){
            h = 3 * h + 1;
        }
        //间隔为n的插入排序
        while (h >= 1){
            for (int i = h; i < length ; i++){
                for (int j = i ;j >= h ; j -= h){
                    //将a[i] a[i-h] a[i -2h] 做插入排序
                    if (less(array[j],array[j-h])){
                        exch(array,j,j-h);
                    }
                }
            }
            h = h/3;
        }

    }

    /**
     * 产生递增序列数组
     * @return
     */
    private int[] generate(int length){
        int[] h = new int[length];
        int temp;
        for (int k = 1 ; k < length ; k++){
            temp = (int) (1/2*(Math.pow(3,k) - 1));
            if (temp > length){
                break;
            }
            h[k-1] = temp;
        }
        return h;
    }

}

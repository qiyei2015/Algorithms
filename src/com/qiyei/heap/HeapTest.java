package com.qiyei.heap;

import com.qiyei.sort.QuickSort;
import com.qiyei.util.LogUtil;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/4/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class HeapTest {
    static Integer[] array = new Integer[100];
    static Random random = new Random();

    public static void main(String[] args){
//        testHeap();
//        testIndexMaxHeap();
//        testIndexMinHeap();
        testTopK();
    }

    /**
     * 测试对
     */
    private static void testHeap() {
        for (int i = 0 ; i < 100;i++){
            array[i] = random.nextInt(100);
        }

        MinPQ<Integer> minPQ = new MinPQ<>(array);
        MaxPQ<Integer> maxPQ = new MaxPQ<>(array);
        for (int i = 0 ; i < 100 ;i++){
            LogUtil.print(minPQ.delMin() + " ");
        }
        LogUtil.println("");
        for (int i = 0 ; i < 100 ;i++){
            LogUtil.print(maxPQ.delMax() + " ");
        }
        LogUtil.println("");
    }


    /**
     * 测试最大索引堆
     */
    private static void testIndexMaxHeap(){
        //索引堆测试
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<>(100);
        for (int i = 0 ; i < 100;i++){
            int value = random.nextInt(100);
            if ( i == 5){
                LogUtil.println("indexMaxHeap index:" + i  + " "+ value);
            }
            indexMaxHeap.insert(i,value);
        }
        LogUtil.println("indexMaxHeap size:" + indexMaxHeap.size());
        LogUtil.println("indexMaxHeap getIndexMax():" + indexMaxHeap.getIndexMax());
        LogUtil.println("indexMaxHeap getMax:" + indexMaxHeap.getMax());

        LogUtil.println("indexMaxHeap getItemIndex(5):" + indexMaxHeap.getItemIndex(5));

        for (int i = 0 ; i < 100;i++){
            LogUtil.println("[ " + indexMaxHeap.getIndexMax() + " " + indexMaxHeap.delMax() + " ]");
        }
    }


    /**
     * 测试最小索引堆
     */
    private static void testIndexMinHeap(){
        //索引堆测试
        IndexMinHeap<Integer> indexMinHeap = new IndexMinHeap<>(100);
        for (int i = 0 ; i < 100;i++){
            int value = random.nextInt(100);
            if ( i == 5){
                LogUtil.println("indexMinHeap index:" + i  + " "+ value);
            }
            indexMinHeap.insert(i,value);
        }
        LogUtil.println("indexMinHeap size:" + indexMinHeap.size());
        LogUtil.println("indexMinHeap getIndexMin():" + indexMinHeap.getIndexMin());
        LogUtil.println("indexMinHeap getMin:" + indexMinHeap.getMin());

        LogUtil.println("indexMinHeap getItemIndex(5):" + indexMinHeap.getItemIndex(5));

        for (int i = 0 ; i < 100;i++){
            LogUtil.println("[ " + indexMinHeap.getIndexMin() + " " + indexMinHeap.delMin() + " ]");
        }
    }

    /**
     * 测试TopK问题
     */
    private static void testTopK(){
        int N = 1000000;
        int M = 100;


        Integer[] array = new Integer[N];
        Integer[] tempArray = new Integer[M];
        Random random = new Random();
        for (int i = 0 ;i < N ; i++){
            array[i] = random.nextInt(10*N);
            if (i < M){
                tempArray[i] = array[i];
            }
        }

        //找出N中M个最大的数
        MinPQ<Integer> minPQ = new MinPQ<>(tempArray);
        for (int i = M ; i< N ;i++){
            if (array[i] > minPQ.getMin()){
                minPQ.replaceTop(array[i]);
            }
        }

        //找出N中M个最小的数
        MaxPQ<Integer> maxPQ = new MaxPQ<>(tempArray);
        for (int i = M ; i< N ;i++){
            if (array[i] < maxPQ.getMax()){
                maxPQ.replaceTop(array[i]);
            }
        }

        //快速排序做参考
        QuickSort quickSort = new QuickSort();
        quickSort.sortThreeWays(array);

        LogUtil.println(N + "中" + M + "个最大的数为:" + minPQ.print());
        LogUtil.println(N + "中" + M + "个最大的数为:" + printArray(array,N-M,N));

        LogUtil.println(N + "中" + M + "个最小的数为:" + maxPQ.print());
        LogUtil.println(N + "中" + M + "个最小的数为:" + printArray(array,0,M));
    }

    /**
     * 打印数组
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static String printArray(Comparable[] arr,int start,int end){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = start ; i < end;i++){
            builder.append(arr[i] + " ");
        }
        builder.append("]");
        return builder.toString();
    }

}

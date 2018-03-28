package com.qiyei.sort;

import com.qiyei.heap.HeapSort;
import com.qiyei.util.LogUtil;
import com.qiyei.util.StopWatch;
import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Created by qiyei2015 on 2018/3/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SortCompare {


    /**
     * 根据参数选择对应的排序
     * @param args
     * @param array
     * @return
     */
    public static double time(String args,Integer[] array){
        StopWatch stopWatch = new StopWatch();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        ShellSort shellSort = new ShellSort();
        MergeSort mergeSort = new MergeSort();
        MergeBUSort mergeSortBU = new MergeBUSort();
        BubbleSort bubbleSort = new BubbleSort();
        QuickSort quickSort = new QuickSort();
        HeapSort heapSort = new HeapSort();

        switch (args){
            case "insertion" :
                insertionSort.sort(array);
                break;
            case "insertionOpt" :
                insertionSort.sortOpt(array);
//                insertionSort.print(array);
                break;
            case "selection" :
                selectionSort.sort(array);
                break;
            case "bubble" :
                bubbleSort.sort(array);
//                bubbleSort.print(array);
                break;
            case "shell" :
                shellSort.sort(array);
//                shellSort.print(array);
                break;
            case "merge" :
                mergeSort.sort(array);
                break;
            case "mergeBU" :
                mergeSortBU.sort(array);
                break;
            case "quick" :
                quickSort.sort(array);
//                quickSort.print(array);
                break;
            case "quick2" :
                quickSort.sortTwoWays(array);
//                quickSort.print(array);
                break;
            case "quick3" :
                quickSort.sortThreeWays(array);
//                quickSort.print(array);
                break;
            case "heap1" :
                heapSort.sort(array);
//                heapSort.print(array);
                break;
            case "heap2" :
                heapSort.sort2(array);
//                heapSort.print(array);
                break;
            default:
                break;
        }
        return stopWatch.elapsedTime();
    }

    /**
     * 将T个长度为N的数组排序
     * @param args
     * @param N
     * @param T
     * @return
     */
    public static double timeRandomInput(String args,int N , int T){
        double total = 0.0;
        Integer[] array = new Integer[N];
        for (int t = 0; t < T ; t++){
            for (int i = 0 ; i < N ; i++){
                array[i] = StdRandom.uniform(N);
            }
            total += time(args,array);
        }
        return total;
    }

    /**
     * 将T个长度为N的数组排序
     * @param args
     * @param N
     * @param T
     * @return
     */
    public static double timeRandomInput(String args,int N , int T, int M){
        double total = 0.0;
        Integer[] array = new Integer[N];
        for (int t = 0; t < T ; t++){
            for (int i = 0 ; i < N ; i++){
                array[i] = StdRandom.uniform(M);
            }
            total += time(args,array);
        }
        return total;
    }

    public static void main(String[] args){

        Double bubbleSort = timeRandomInput("bubble",10000,5);
        Double shell = timeRandomInput("shell",10000,5);
        Double insertion = timeRandomInput("insertion",10000,5);
        Double insertionOpt = timeRandomInput("insertionOpt",10000,5);
        Double selection = timeRandomInput("selection",10000,5);
        Double merge = timeRandomInput("merge",10000,5);
        Double mergeBU = timeRandomInput("mergeBU",10000,5);
        Double quick = timeRandomInput("quick",10000,5,100);
        Double quick2Ways = timeRandomInput("quick2",10000,5,100);
        Double quick3Ways = timeRandomInput("quick3",10000,5,100);
        Double heap1 = timeRandomInput("heap1",10000,5,100);

        LogUtil.println("bubbleSort:" + bubbleSort);
        LogUtil.println("selection:" + selection);
        LogUtil.println("insertion:" + insertion);
        LogUtil.println("insertionOpt:" + insertionOpt);
        LogUtil.println("shell:" + shell);
        LogUtil.println("merge:" + merge);
        LogUtil.println("mergeBU:" + mergeBU);
        LogUtil.println("quick:" + quick);
        LogUtil.println("quick2Ways:" + quick2Ways);
        LogUtil.println("quick3Ways:" + quick3Ways);
        LogUtil.println("heap1:" + heap1);

//        testHeap();

    }

    private static void testHeap(){
        Integer[] a = new Integer[100];
        MaxPQ<Integer> maxPQ = new MaxPQ<>(100);

        for (int i = 0; i < 100 ; i++){
            a[i] = StdRandom.uniform(1000);
            maxPQ.insert(a[i]);
        }

        for (int i = 0; i < 100 ; i++){
            LogUtil.print(" "+ maxPQ.delMax());
        }

    }

}

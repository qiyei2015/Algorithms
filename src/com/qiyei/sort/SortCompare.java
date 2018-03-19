package com.qiyei.sort;

import com.qiyei.util.LogUtil;
import com.qiyei.util.StopWatch;
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
    public static double time(String args,Double[] array){
        StopWatch stopWatch = new StopWatch();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        ShellSort shellSort = new ShellSort();
        MergeSort mergeSort = new MergeSort();
        BubbleSort bubbleSort = new BubbleSort();

        switch (args){
            case "insertion" :
                insertionSort.sort(array);
                break;
            case "selection" :
                selectionSort.sort(array);
                break;
            case "bubble" :
                bubbleSort.sort(array);
                break;
            case "shell" :
                shellSort.sort(array);
//                shellSort.print(array);
                break;
            case "merge" :
                mergeSort.sort(array);
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
        Double[] array = new Double[N];
        for (int t = 0; t < T ; t++){
            for (int i = 0 ; i < N ; i++){
                array[i] = StdRandom.uniform();
            }
            total += time(args,array);
        }
        return total;
    }

    public static void main(String[] args){

        Double bubbleSort = timeRandomInput("bubble",10000,5);
        Double shell = timeRandomInput("shell",10000,5);
        Double insertion = timeRandomInput("insertion",10000,5);
        Double selection = timeRandomInput("selection",10000,5);
        Double merge = timeRandomInput("merge",10000,5);

        LogUtil.println("bubbleSort:" + bubbleSort);
        LogUtil.println("selection:" + selection);
        LogUtil.println("insertion:" + insertion);
        LogUtil.println("shell:" + shell);
        LogUtil.println("merge:" + merge);

    }

}

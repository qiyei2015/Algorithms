package com.qiyei.util;

/**
 * @author Created by qiyei2015 on 2018/1/6.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LogUtil {

    /**
     * 显示日志
     * @param TAG
     * @param message
     */
    public static void println(String TAG,String message){
        System.out.println(TAG + " " + message);
    }

    /**
     * 打印，不换行
     * @param message
     */
    public static void print(String message){
        System.out.print(message);
    }

    /**
     * 打印，不换行
     * @param message
     */
    public static void println(String message){
        System.out.println(message);
    }

    /**
     * 打印数组
     * @param array
     */
    public static void printArray(Comparable[] array){
        for (int i = 0 ;i < array.length ; i++){
            LogUtil.print(array[i] + " ");
            //每10个数换一行
            if ((i + 1) % 10 == 0){
                LogUtil.print("\n");
            }
        }
        LogUtil.print("\n");
    }

    /**
     * 打印数组
     * @param array
     */
    public static void printArray(int[] array){
        for (int i = 0 ;i < array.length ; i++){
            LogUtil.print(array[i] + " ");
            //每10个数换一行
            if ((i + 1) % 10 == 0){
                LogUtil.print("\n");
            }
        }
        LogUtil.print("\n");
    }

    /**
     * 打印数组
     * @param array
     */
    public static void printArray(char[] array){
        for (int i = 0 ;i < array.length ; i++){
            LogUtil.print(array[i] + " ");
            //每10个数换一行
            if ((i + 1) % 10 == 0){
                LogUtil.print("\n");
            }
        }
        LogUtil.print("\n");
    }
}
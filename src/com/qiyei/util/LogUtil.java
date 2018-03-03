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

}
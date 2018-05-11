package com.qiyei.array;

import com.qiyei.util.LogUtil;

/**
 * @author Created by qiyei2015 on 2018/5/8.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class ArrayUtil {

    /**
     * 方向
     */
    public enum Dir{
        NONE,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }

    /**
     * 打印二位数组
     * @param array
     * @param dir 方向
     */
    public static void printTwoDimensionalArray(int[][] array,Dir dir){

        switch (dir){
            case TOP_LEFT:
                printTwoDimensionalArrayTopLeft(array);
                break;
            case TOP_RIGHT:
                printTwoDimensionalArrayTopRight(array);
                break;
            case BOTTOM_LEFT:
                printTwoDimensionalArrayBottomLeft(array);
                break;
            case BOTTOM_RIGHT:
                printTwoDimensionalArrayBottomRight(array);
                break;
            default:
                printTwoDimensionalArray(array);
                break;
        }
    }

    /**
     * 打印二维矩阵数组
     * @param array
     */
    private static void printTwoDimensionalArray(int[][] array){
        //行 共有 0 -- row-1 行
        int row = array.length;
        //列 共有 0 -- column-1 行
        int column = array.length;

        int maxSize = row * column;
        int len = (maxSize + "").length();

        //初始角标
        int i = 0;
        int j = 0;

        for (i = 0 ; i <= row - 1; i++){
            for (j = 0 ; j <= column - 1 ; j++){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ")+ " ");
            }
            //换行
            LogUtil.println("");
        }
        LogUtil.println("");
    }


    /**
     * 左上角开始打印二维矩阵数组
     * @param array
     */
    private static void printTwoDimensionalArrayTopLeft(int[][] array){
        //行 共有 0 -- row-1 行
        int row = array.length;
        //列 共有 0 -- column-1 行
        int column = array.length;

        int maxSize = row * column;
        int len = (maxSize + "").length();

        //初始角标
        int i = 0;
        int j = 0;

        //左上角，我们可以认为先从0 到 column - 1 列
        for (int k = 0 ; k <= column - 1; k++){
            //每一列的循环 行下标i会增加，列下标j会减少
            for (i = 0 ,j = k; i <= k && j >= 0 ; i++,j--){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ") + " ");
            }
            //换行
            LogUtil.println("");
        }

        //再从1 到 row - 1 行
        for (int k = 1 ; k <= row - 1; k++){
            //每一列的循环 行下标i会增加，列下标j会减少
            for (i = k ,j = row - 1; i <= row - 1 && j >= 0 ; i++,j--){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ") + " ");
            }
            //换行
            LogUtil.println("");
        }
        LogUtil.println("");
    }

    /**
     * 左上角开始打印二维矩阵数组
     * @param array
     */
    private static void printTwoDimensionalArrayTopRight(int[][] array){
        //行 共有 0 -- row-1 行
        int row = array.length;
        //列 共有 0 -- column-1 行
        int column = array.length;

        int maxSize = row * column;
        int len = (maxSize + "").length();

        //初始角标
        int i = 0;
        int j = column - 1;

        //右上角，我们可以认为先从column - 1 到 0 列
        for (int k = column - 1 ; k >= 0; k--){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (i = 0 ,j = k; i <= column - 1 - k && j <= column - 1 ; i++,j++){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ") + " ");
            }
            //换行
            LogUtil.println("");
        }

        //再从1 到 row - 1 行
        for (int k = 1 ; k <= row - 1; k++){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (i = k ,j = 0; i <= row - 1 && j <= row - 1 - k ; i++,j++){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ") + " ");
            }
            //换行
            LogUtil.println("");
        }
        LogUtil.println("");
    }

    /**
     * 左下角开始打印二维矩阵数组
     * @param array
     */
    private static void printTwoDimensionalArrayBottomLeft(int[][] array){
        //行 共有 0 -- row-1 行
        int row = array.length;
        //列 共有 0 -- column-1 行
        int column = array.length;

        int maxSize = row * column;
        int len = (maxSize + "").length();

        //初始角标
        int i = row - 1;
        int j = 0;

        //右上角，我们可以认为先从row - 1 到 0 行
        for (int k = row - 1 ; k >= 0; k--){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (i = k ,j = 0; i <= row - 1 && j <= row - 1 - k ; i++,j++){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ") + " ");
            }
            //换行
            LogUtil.println("");
        }

        //再从1 到 co - 1 列
        for (int k = 1 ; k <= column - 1; k++){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (i = 0 ,j = k; i <= column - 1 - k && j <= column - 1 ; i++,j++){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ") + " ");
            }
            //换行
            LogUtil.println("");
        }
        LogUtil.println("");
    }


    /**
     * 右下角开始打印二维矩阵数组
     * @param array
     */
    private static void printTwoDimensionalArrayBottomRight(int[][] array){
        //行 共有 0 -- row-1 行
        int row = array.length;
        //列 共有 0 -- column-1 行
        int column = array.length;

        int maxSize = row * column;
        int len = (maxSize + "").length();

        //初始角标
        int i = row - 1;
        int j = column - 1;

        //右上角，我们可以认为先从row - 1 到 0 行
        for (int k = row - 1 ; k >= 0; k--){
            //每一列的循环 行下标i会增加，列下标j减少
            for (i = k ,j = row - 1; i <= row - 1 && j >= k ; i++,j--){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ") + " ");
            }
            //换行
            LogUtil.println("");
        }

        //再从column - 2 到 0列
        for (int k = column - 2 ; k >= 0; k--){
            //每一列的循环 行下标i会增加，列下标j会减少
            for (i = 0 ,j = k; i <= k && j >= 0 ; i++,j--){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ") + " ");
            }
            //换行
            LogUtil.println("");
        }
        LogUtil.println("");
    }



    /**
     * 获取定长的字符串
     * @param str 原始字符串
     * @param len 固定长度
     * @param c 不够填充的字符
     * @return 固定长度的字符串
     */
    public static String getFixedLenString(String str, int len, String c) {
        if (str == null || str.length() == 0){
            str = "";
        }
        if (str.length() == len){
            return str;
        }
        if (str.length() > len){
            return str.substring(0,len);
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < len){
            sb.append(c);
        }
        return sb.toString();
    }

}

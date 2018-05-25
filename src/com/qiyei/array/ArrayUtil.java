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
        int n = array.length;

        int maxSize = n * n;
        int len = (maxSize + "").length();

        //初始角标
        int i = 0;
        int j = 0;

        for (i = 0 ; i <= n - 1; i++){
            for (j = 0 ; j <= n - 1 ; j++){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ")+ " ");
            }
            //换行
            LogUtil.println("");
        }
        LogUtil.println("");
    }


    /**
     * 左上角开始打印二维矩阵数组，按照顺时针方向来选取
     * @param array
     */
    private static void printTwoDimensionalArrayTopLeft(int[][] array){
        int n = array.length;
        int maxSize = n * n;
        int len = (maxSize + "").length();

        //初始角标
        int i = 0;
        int j = 0;

        //左上角，我们可以认为先从0 到 n - 1 列
        for (int k = 0 ; k <= n - 1; k++){
            //每一列的循环 行下标i会增加，列下标j会减少
            for (i = 0 ,j = k; i <= k && j >= 0 ; i++,j--){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ") + " ");
            }
            //换行
            LogUtil.println("");
        }

        //再从1 到 n - 1 行
        for (int k = 1 ; k <= n - 1; k++){
            //每一列的循环 行下标i会增加，列下标j会减少
            for (i = k ,j = n - 1; i <= n - 1 && j >= k ; i++,j--){
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
        int n = array.length;
        int maxSize = n * n;
        int len = (maxSize + "").length();

        //初始角标
        int i = 0;
        int j = 0;

        //右上角，我们可以认为先从n - 1 到 0 列
        for (int k = n - 1 ; k >= 0; k--){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (i = 0 ,j = k; i <= n - 1 - k && j <= n - 1 ; i++,j++){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ") + " ");
            }
            //换行
            LogUtil.println("");
        }

        //再从1 到 n - 1 行
        for (int k = 1 ; k <= n - 1; k++){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (i = k ,j = 0; i <= n - 1 && j <= n - 1 - k ; i++,j++){
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
        int n = array.length;

        int maxSize = n * n;
        int len = (maxSize + "").length();

        //初始角标
        int i = n - 1;
        int j = 0;

        //右上角，我们可以认为先从row - 1 到 0 行
        for (int k = n - 1 ; k >= 0; k--){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (i = k ,j = 0; i <= n - 1 && j <= n - 1 - k ; i++,j++){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ") + " ");
            }
            //换行
            LogUtil.println("");
        }

        //再从1 到 co - 1 列
        for (int k = 1 ; k <= n - 1; k++){
            //每一列的循环 行下标i会增加，列下标j会增加
            for (i = 0 ,j = k; i <= n - 1 - k && j <= n - 1 ; i++,j++){
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
        int n = array.length;

        int maxSize = n * n;
        int len = (maxSize + "").length();

        //初始角标
        int i = n - 1;
        int j = n - 1;

        //右上角，我们可以认为先从row - 1 到 0 行
        for (int k = n - 1 ; k >= 0; k--){
            //每一列的循环 行下标i会增加，列下标j减少
            for (i = k ,j = n - 1; i <= n - 1 && j >= k ; i++,j--){
                LogUtil.print(getFixedLenString(array[i][j] + "",len," ") + " ");
            }
            //换行
            LogUtil.println("");
        }

        //再从column - 2 到 0列
        for (int k = n - 2 ; k >= 0; k--){
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

    /**
     * 交换数组
     * @param array
     * @param i
     * @param j
     */
    public static void exch(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 交换char
     * @param array
     * @param i
     * @param j
     */
    public static void exch(char[] array,int i,int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

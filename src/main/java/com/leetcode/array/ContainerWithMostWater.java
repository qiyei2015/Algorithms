package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2018/5/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 11 盛水最多的容器
 */
public class ContainerWithMostWater {

    private int[] index = new int[2];

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;

        while (i < j){

            if (max < calculateArea(height,i,j)){
                max = calculateArea(height,i,j);
                index[0] = i;
                index[1] = j;
            }

            if (height[i] < height[j]){
                i++;
            }else {
                j--;
            }
        }
        return max;
    }

    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int max = 0;
        for (int i = 0 ; i < height.length ;i++){
            for (int j = i + 1;j < height.length ;j++){
                if (max < calculateArea(height,i,j)){
                    max = calculateArea(height,i,j);
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return max;
    }

    private int calculateArea(int[] height,int i,int j){
        int dis = j - i;
        int hei = Math.min(height[i],height[j]);
        return dis * hei;
    }
}

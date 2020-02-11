package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2020/2/11.
 * @version: 1.0 <br>
 * @email: 1273482124@qq.com
 * @description: 240. 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class SearchA2DMatrix_ii_240 {

    int m,n;

    public boolean searchMatrix(int[][] matrix, int target) {
        n = matrix.length;
        if (matrix.length <= 0){
            return false;
        }
        m = matrix[0].length;
        if (m <= 0){
            return false;
        }
        System.out.println("m=" + m + " n=" +n);
        return search(matrix,target);
    }

    private boolean search(int[][] matrix, int target){
        int row = matrix.length;
        if (row <= 0){
            return false;
        }
        int column = matrix[0].length;

        int i = row - 1;
        int j = 0;

        while ( i >= 0 && j <= column - 1){
            if (target > matrix[i][j]){
                j++;
            } else if (target < matrix[i][j]){
                i--;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] array = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] arr2 = new int[][]{{1},{3},{5}};
        System.out.println(new SearchA2DMatrix_ii_240().search(array,111));

    }

}

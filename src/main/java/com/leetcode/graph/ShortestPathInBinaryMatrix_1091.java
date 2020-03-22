package com.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Created by qiyei2015 on 2020/3/11.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class ShortestPathInBinaryMatrix_1091 {

    private int mRow;
    private int mColumn;
    private int[][] mGraph;

    private boolean[] mVisited;

    private int[] mDep;

    //八连通
    private int[][] dist = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0){
            return -1;
        }
        if (grid[0].length == 0){
            return -1;
        }

        mRow = grid.length;
        mColumn = grid[0].length;

        if (grid[0][0] == 1){
            return -1;
        }

        if (mRow == 0 && mColumn == 0){
            return -1;
        }

        if (mRow == 1 && mColumn == 1 && grid[0][0] == 0){
            return 1;
        }

        //构造图
        mGraph = grid;
        mVisited = new boolean[mRow * mColumn];
        mDep = new int[mRow * mColumn];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        mVisited[0] = true;
        mDep[0] = 1;

        while (!queue.isEmpty()){
            int v = queue.remove();
            int x = v / mColumn;
            int y = v % mColumn;
            //添加相邻的点到队列中
            List<Integer> list = new ArrayList<>();

            for (int i = 0 ;i < dist.length ; i++){
                int nextX = x + dist[i][0];
                int nextY = y + dist[i][1];
                if (inArea(nextX,nextY) && mGraph[nextX][nextY] == 0){
                    list.add(nextX * mColumn + nextY);
                }
            }
            for (int w : list){
                int dx = w / mColumn;
                int dy = w % mColumn;
                if (!mVisited[w]){
                    mVisited[w] = true;
                    mDep[w] = mDep[v] + 1;
                    queue.add(w);
                    if (w == mRow * mColumn - 1){
                        return mDep[mRow * mColumn - 1];
                    }
                }
            }
        }
        return -1;
    }

    private boolean inArea(int x,int y){
        return x >= 0 && x < mRow && y >=0 && y < mColumn;
    }
}

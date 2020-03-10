package com.leetcode.graph;

/**
 * @author Created by qiyei2015 on 2020/3/10.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 695. 岛屿的最大面积
 */
public class MaxAreaOfIsland_695 {

    private int mRow;
    private int mColumn;
    private int[][] mGraph;

    private boolean[][] mVisited;

    //四连通
    private int[][] dist = {{-1,0},{0,-1},{1,0},{0,1}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        if (grid[0].length == 0){
            return 0;
        }

        mRow = grid.length;
        mColumn = grid[0].length;
        //构造图
        mGraph = grid;
        mVisited = new boolean[mRow][mColumn];
        int res = 0;

        for (int i = 0; i < mRow ;i++){
            for (int j = 0 ;j < mColumn ;j++){
                if (!mVisited[i][j] && mGraph[i][j] == 1){
                    res = Math.max(dfs(i,j),res);
                }
            }
        }
        return res;
    }

    /**
     * dfs,返回连通分量的值
     * @param x
     * @param y
     * @return
     */
    private int dfs(int x,int y){
        mVisited[x][y] = true;
        int count = 1;
        //v相邻的结点
        for (int i = 0 ; i < dist.length ; i++){
            int nextX = dist[i][0] + x;
            int nextY = dist[i][1] + y;
            if (inArea(nextX,nextY) && !mVisited[nextX][nextY] && mGraph[nextX][nextY] == 1){
                count += dfs(nextX,nextY);
            }
        }
        return count;
    }

    private boolean inArea(int x,int y){
        return x >= 0 && x < mRow && y >= 0 && y < mColumn;
    }

}

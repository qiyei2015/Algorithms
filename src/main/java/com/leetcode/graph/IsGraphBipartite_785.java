package com.leetcode.graph;

/**
 * @author Created by qiyei2015 on 2020/3/10.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 785. 判断二分图
 *
 * 判断是否是二分图
 */
public class IsGraphBipartite_785 {

    private boolean[] mVisited;
    private int[] mColor;
    private int[][] mGraph;

    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0){
            return false;
        }
        mVisited = new boolean[graph.length];
        mColor = new int[graph.length];
        mGraph = graph;
        //使用dfs
        for (int v = 0; v < graph.length ; v++){
            if (!mVisited[v]){
                if (!dfs(v,0)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int v,int color){
        mVisited[v] = true;
        mColor[v] = color;
        for (int w:mGraph[v]){
            if (!mVisited[w]){
                if (!dfs(w,1 - color)){
                    return false;
                }
            } else if (mColor[w] == mColor[v]){
                //两个颜色相同就不是二分图了
                return false;
            }
        }
        return true;
    }
}

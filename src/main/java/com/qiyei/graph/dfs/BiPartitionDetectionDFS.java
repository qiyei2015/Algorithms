package com.qiyei.graph.dfs;

import com.qiyei.graph.Graph;
import com.qiyei.graph.impl.GraphImpl;

/**
 * @author Created by qiyei2015 on 2020/3/22.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 二分图检测，基于DFS
 */
public class BiPartitionDetectionDFS {

    private Graph mGraph;

    /**
     * 是否被访问过
     */
    private boolean[] mVisited;
    /**
     * 记录每个订单的颜色
     */
    private int[] mColor;

    private boolean isBipartite = true;

    public BiPartitionDetectionDFS(Graph graph) {
        mGraph = graph;
        mVisited = new boolean[graph.V()];
        mColor = new int[graph.V()];

        for (int v = 0; v < graph.V() ;v++){
            if (!mVisited[v]){
                if (!dfs(v,0)){
                    isBipartite = false;
                    break;
                }
            }
        }
    }

    /**
     * dfs 判断是否是二分图
     * @param v
     * @param color v要染成的颜色
     * @return
     */
    private boolean dfs(int v,int color){
        mVisited[v] = true;
        mColor[v] = color;
        for (int w : mGraph.adj(v)){
            if (!mVisited[w]){
                if (!dfs(w,1 - color)){
                    return false;
                }
            } else if (mColor[w] == mColor[v]){
                return false;
            }
        }
        return true;
    }

    /**
     * 是否是二分图
     * @return
     */
    public boolean isBipartite(){
        return isBipartite;
    }

    public static void main(String[] args) {
        Graph Graph = new GraphImpl("g3.txt");
        BiPartitionDetectionDFS biPartitionDetectionDFS  = new BiPartitionDetectionDFS(Graph);
        System.out.println(biPartitionDetectionDFS.isBipartite());
    }
}

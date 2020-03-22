package com.qiyei.graph.bfs;


import com.qiyei.graph.Graph;
import com.qiyei.graph.impl.GraphImpl;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Created by qiyei2015 on 2020/3/8.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 二分图检测基于BFS
 *
 */
public class BiPartitionDetectionBFS {

    private Graph mGraph;
    private boolean[] mVisited;
    /**
     * 每个顶点对应的颜色
     */
    private int[] mColor;

    private boolean isBipartite = true;

    public BiPartitionDetectionBFS(Graph graph) {
        mGraph = graph;
        mVisited = new boolean[mGraph.V()];
        mColor = new int[mGraph.V()];
        for(int i = 0; i < mColor.length; i ++){
            mColor[i] = -1;
        }
        for (int v = 0 ; v < mGraph.V() ; v++){
            if (!mVisited[v]){
                if (!bfs(v)){
                    isBipartite = false;
                    break;
                }
            }
        }

    }

    /**
     * 以s开始bfs，并判断是否是二分图
     * @param s
     * @return
     */
    private boolean bfs(int s){
        mVisited[s] = true;
        mColor[s] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        while (!queue.isEmpty()){
            Integer v = queue.poll();
            for (int w : mGraph.adj(v)){
                if (!mVisited[w]){
                    mVisited[w] = true;
                    mColor[w] = 1 - mColor[v];
                } else if (mColor[v] == mColor[w]){
                    //以及遍历过的结点，如果颜色相等，就说明不是二分图了
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(){
        return isBipartite;
    }

    public static void main(String[] args) {
        Graph Graph = new GraphImpl("g3.txt");
        BiPartitionDetectionBFS biPartitionDetectionBFS  = new BiPartitionDetectionBFS(Graph);
        System.out.println(biPartitionDetectionBFS.isBipartite());
    }
}

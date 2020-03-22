package com.qiyei.Graph.dfs;


import com.qiyei.graph.Graph;
import com.qiyei.graph.impl.GraphImpl;

/**
 * @author Created by qiyei2015 on 2020/3/8.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 无向图的环检测基于dfs
 *
 */
public class CycleDetectionDFS {

    private Graph mGraph;
    /**
     * 记录是否访问过
     */
    private boolean[] mVisited;
    private boolean hasCycle = false;

    public CycleDetectionDFS(Graph Graph) {
        mGraph = Graph;
        mVisited = new boolean[mGraph.V()];

        for (int v = 0 ; v < mGraph.V() ; v++){
            if (dfs(v,v)){
                hasCycle = true;
                break;
            }
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    /**
     * dfs判断是否有环
     * @param v
     * @param parent 遍历v时的父亲结点
     * @return
     */
    private boolean dfs(int v,int parent){
        mVisited[v] = true;
        for (int w: mGraph.adj(v)){
            if (!mVisited[w]){
                if (dfs(w,v)){
                    return true;
                }
            } else if (w != parent){
                //已经遍历过的结点不是父结点
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph Graph = new GraphImpl("g3.txt");
        CycleDetectionDFS cycleDetection = new CycleDetectionDFS(Graph);
        System.out.println(cycleDetection.hasCycle());
    }
}

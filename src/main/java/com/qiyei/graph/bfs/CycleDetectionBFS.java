package com.qiyei.graph.bfs;


import com.qiyei.graph.Graph;
import com.qiyei.graph.impl.GraphImpl;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Created by qiyei2015 on 2020/3/8.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 无向图的环检测
 *
 */
public class CycleDetectionBFS {

    private Graph mGraph;
    /**
     * 记录是否访问过
     */
    private boolean[] mVisited;
    /**
     *
     */
    private int[] mPre;

    private boolean hasCycle = false;

    public CycleDetectionBFS(Graph Graph) {
        mGraph = Graph;
        mVisited = new boolean[mGraph.V()];
        mPre = new int[mGraph.V()];
        for(int i = 0; i < mPre.length; i ++){
            mPre[i] = -1;
        }

        for (int v = 0 ; v < mGraph.V() ; v++){
            if (bfs(v)){
                hasCycle = true;
                break;
            }
        }
    }

    /**
     * 从顶点开始bfs。判断是否有环
     * @param s
     * @return
     */
    private boolean bfs(int s){
        mVisited[s] = true;
        mPre[s] = s;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        while (!queue.isEmpty()){
            Integer v = queue.poll();
            for (int w : mGraph.adj(v)){
                if (!mVisited[w]){
                    mVisited[w] = true;
                    //w从v遍历过来的
                    mPre[w] = v;
                    queue.add(w);
                } else if (mPre[v] != w){
                    //如果当前遍历的结点的是被访问过的，只用查看当前的结点是否从该结点过来，不是的话就有环
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph Graph = new GraphImpl("g3.txt");
        CycleDetectionBFS cycleDetection = new CycleDetectionBFS(Graph);
        System.out.println(cycleDetection.hasCycle());
    }
}

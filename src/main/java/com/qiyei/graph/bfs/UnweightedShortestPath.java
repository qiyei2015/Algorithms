package com.qiyei.graph.bfs;

import com.qiyei.graph.Graph;
import com.qiyei.graph.impl.GraphImpl;

import java.util.*;

/**
 * @author Created by qiyei2015 on 2020/3/8.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 * 无权图的最短路径
 */
public class UnweightedShortestPath {

    private Graph mGraph;
    private int mSource;
    private boolean[] mVisited;
    private int[] mPre;
    //记录从source遍历时的深度
    private int[] mDis;

    public UnweightedShortestPath(Graph G, int source){

        this.mGraph = G;
        this.mSource = mSource;

        mVisited = new boolean[G.V()];
        mPre = new int[G.V()];
        mDis = new int[G.V()];
        for(int i = 0; i < G.V(); i ++) {
            mPre[i] = -1;
            mDis[i] = -1;
        }
        bfs(mSource);
    }

    private void bfs(int s){
        mVisited[s] = true;
        mPre[s] = s;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        mDis[s] = 0;
        while (!queue.isEmpty()){
            Integer v = queue.poll();
            for (int w : mGraph.adj(v)){
                if (!mVisited[w]){
                    mVisited[w] = true;
                    //w从v遍历过来的
                    mPre[w] = v;
                    mDis[w] = mDis[v] + 1;
                    queue.add(w);
                }
            }
        }
    }

    public boolean isConnectedTo(int t){
        mGraph.validateVertex(t);
        return mVisited[t];
    }

    /**
     * 从source遍历到t深度
     * @param t
     * @return
     */
    public int dis(int t){
        mGraph.validateVertex(t);
        return mDis[t];
    }

    public List<Integer> path(int t){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(!isConnectedTo(t)) return res;
        int cur = t;
        while(cur != mSource){
            res.add(cur);
            cur = mPre[cur];
        }
        res.add(mSource);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Graph g = new GraphImpl("g.txt");
        UnweightedShortestPath usssPath = new UnweightedShortestPath(g, 0);
        System.out.println("0 -> 6 : " + usssPath.path(6));
        System.out.println("0 -> 6 : " + usssPath.dis(6));
    }
}

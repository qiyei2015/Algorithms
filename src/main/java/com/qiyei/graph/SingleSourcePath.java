package com.qiyei.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/3/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 * 单源如今算法
 */
public class SingleSourcePath {

    private IGraph mGraph;
    private boolean[] mVisited;
    //记录到达index处的前一个点
    private int[] mPre;
    private int mSource;

    public SingleSourcePath(IGraph graph,int source) {
        mGraph = graph;
        mGraph.validateVertex(source);
        mSource = source;
        mVisited = new boolean[mGraph.V()];
        mPre = new int[mGraph.V()];

        for (int i = 0 ; i < mGraph.V() ; i++){
            mVisited[i] = false;
            mPre[i] = -1;
        }
        dfs(source,0);
    }

    public boolean hasPath(int w){
        mGraph.validateVertex(w);
        return mVisited[w];
    }

    public List<Integer> path(int t){
        List<Integer> res = new ArrayList<Integer>();
        if(!hasPath(t)) {
            return res;
        }
        int cur = t;
        while(cur != mSource){
            res.add(cur);
            cur = mPre[cur];
        }
        res.add(mSource);
        Collections.reverse(res);
        return res;
    }

    private void dfs(int v,int parent){
        mVisited[v] = true;
        mPre[v] = parent;
        for (int w: mGraph.adj(v)){
            if (!mVisited[w]){
                dfs(w,v);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph("g2.txt");
        SingleSourcePath sspath = new SingleSourcePath(g, 1);
        System.out.println("1 -> 6 : " + sspath.path(6));
        System.out.println("1 -> 5 : " + sspath.path(5));
    }
}

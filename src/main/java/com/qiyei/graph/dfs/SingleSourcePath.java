package com.qiyei.graph.dfs;

import com.qiyei.graph.impl.GraphImpl;
import com.qiyei.graph.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/3/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 * 无权图单源路径算法
 */
public class SingleSourcePath {

    private Graph mGraph;
    private boolean[] mVisited;
    //记录到达index处的前一个点
    private int[] mPre;
    private int mSource;

    public SingleSourcePath(Graph graph, int source) {
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

    /**
     * 到w这一点是否有路径
     * @param w
     * @return
     */
    public boolean hasPath(int w){
        mGraph.validateVertex(w);
        return mVisited[w];
    }

    /**
     * 到w的路径
     * @param t
     * @return
     */
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

    /**
     * dfs,
     * @param v
     * @param parent 父亲结点
     */
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
        GraphImpl g = new GraphImpl("g2.txt");
        SingleSourcePath sspath = new SingleSourcePath(g, 1);
        System.out.println("1 -> 6 : " + sspath.path(6));
        System.out.println("1 -> 5 : " + sspath.path(5));
    }
}

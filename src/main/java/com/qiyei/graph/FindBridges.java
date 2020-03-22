package com.qiyei.graph;

import com.qiyei.graph.impl.GraphImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/3/22.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 寻找图的桥
 */
public class FindBridges {

    private Graph mGraph;

    /**
     * 是否被访问过
     */
    private boolean[] mVisited;
    /**
     * 记录每个点到达的顺序
     */
    private int[] mOrd;
    /**
     * 记录每个点能到底的最小的结点
     */
    private int[] mLow;
    /**
     * 桥的结果
     */
    private List<Edge> mBrides;
    /**
     * 递归计数
     */
    private int cnt;

    public FindBridges(Graph g) {
        mGraph = g;
        mVisited = new boolean[mGraph.V()];
        mOrd = new int[mGraph.V()];
        mLow = new int[mGraph.V()];
        mBrides = new ArrayList<>();
        cnt = 0;
        for (int v = 0; v < mGraph.V() ;v++){
            if (!mVisited[v]){
                dfs(v,v);
            }
        }
    }

    /**
     * dfs寻找桥
     * @param v
     * @param parent
     */
    private void dfs(int v,int parent){
        mVisited[v] = true;
        mOrd[v] = cnt;
        mLow[v] = mOrd[v];

        cnt++;
        for (int w : mGraph.adj(v)){
            if (!mVisited[w]){
                dfs(w,v);
                //更新v能到达的最小值
                mLow[v] = Math.min(mLow[w],mLow[v]);
                //如果这条边的另外一个顶点能到达的最小值大于该顶点的访问顺序，这条边就是桥
                if (mLow[w] > mOrd[v]){
                    mBrides.add(new Edge(v,w));
                }
            } else if (w != parent){
                //是一个环
                mLow[v] = Math.min(mLow[w],mLow[v]);
            }
        }


    }

    /**
     * 返回图的桥
     * @return
     */
    public List<Edge> findBridges(){
        return mBrides;
    }

    public static void main(String[] args) {
        Graph graph1 = new GraphImpl("g.txt");
        FindBridges findBridges = new FindBridges(graph1);
        System.out.println(findBridges.findBridges());

        Graph graph2 = new GraphImpl("g2.txt");
        FindBridges findBridges2 = new FindBridges(graph2);
        System.out.println(findBridges2.findBridges());

        Graph graph3 = new GraphImpl("g3.txt");
        FindBridges findBridges3 = new FindBridges(graph3);
        System.out.println(findBridges3.findBridges());
    }
}

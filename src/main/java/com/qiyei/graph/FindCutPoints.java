package com.qiyei.graph;

import com.qiyei.graph.impl.GraphImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/3/22.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 寻找图的割点
 */
public class FindCutPoints {

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
    private List<Integer> mCutPoints;
    /**
     * 递归计数
     */
    private int cnt;

    public FindCutPoints(Graph g) {
        mGraph = g;
        mVisited = new boolean[mGraph.V()];
        mOrd = new int[mGraph.V()];
        mLow = new int[mGraph.V()];
        mCutPoints = new ArrayList<>();
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
        int child = 0;

        for (int w : mGraph.adj(v)){
            if (!mVisited[w]){
                dfs(w,v);
                //更新v能到达的最小值
                mLow[v] = Math.min(mLow[w],mLow[v]);
                //不是根结点
                if (v != parent  && mLow[w] >= mOrd[v]){
                    mCutPoints.add(v);
                }
                child++;
                if (v == parent && child > 1){
                    mCutPoints.add(v);
                }

            } else if (w != parent){
                //是一个环
                mLow[v] = Math.min(mLow[w],mLow[v]);
            }
        }


    }

    /**
     * 返回图的割点
     * @return
     */
    public List<Integer> findCutPoints(){
        return mCutPoints;
    }

    public static void main(String[] args) {
        Graph graph1 = new GraphImpl("g.txt");
        FindCutPoints findCutPoints1 = new FindCutPoints(graph1);
        System.out.println(findCutPoints1.findCutPoints());

        Graph graph2 = new GraphImpl("g2.txt");
        FindCutPoints findCutPoints2 = new FindCutPoints(graph2);
        System.out.println(findCutPoints2.findCutPoints());

        Graph graph3 = new GraphImpl("g3.txt");
        FindCutPoints findCutPoints3 = new FindCutPoints(graph3);
        System.out.println(findCutPoints3.findCutPoints());
    }


}

package com.qiyei.graph;

import com.qiyei.graph.impl.GraphImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/3/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class HamiltonPath {

    private Graph mGraph;

    /**
     * 是否被访问过
     */
    private boolean[] mVisited;
    /**
     * 记录每个点的前一个结点
     */
    private int[] mPre;
    /**
     * 起始点
     */
    private int mSource;
    /**
     * 遍历结果
     */
    private List<Integer> mOrder;
    /**
     * 记录最后一个遍历的结点
     */
    private int end;

    public HamiltonPath(Graph graph,int source) {
        mGraph = graph;
        mSource = source;
        mVisited = new boolean[mGraph.V()];
        mPre = new int[mGraph.V()];
        mOrder = new ArrayList<>();
        end = -1;
        dfs(mSource,mSource,mGraph.V());
    }

    /**
     * dfs 判断是否存在哈密尔顿回路
     * @param v
     * @param parent
     * @param remain
     * @return
     */
    private boolean dfs(int v,int parent,int remain){
        mVisited[v] = true;
        mPre[v] = parent;
        remain--;
        //只用全部遍历完
        if (remain == 0){
            end = v;
            return true;
        }
        for (int w : mGraph.adj(v)){
            if (!mVisited[w]){
                if (dfs(w,v,remain)){
                    return true;
                }
            }
        }

        mVisited[v] = false;
        return false;
    }

    /**
     * 返回哈密尔顿回路
     * @return
     */
    public List<Integer> hamiltonLoop(){
        mOrder.clear();
        if (end == -1){
            return mOrder;
        }
        int cur = end;
        while (cur != mSource){
            mOrder.add(cur);
            cur = mPre[cur];
        }
        mOrder.add(mSource);
        Collections.reverse(mOrder);
        return mOrder;
    }

    public static void main(String[] args) {
        Graph g = new GraphImpl("g4.txt");
        HamiltonPath hl = new HamiltonPath(g,0);
        System.out.println(hl.hamiltonLoop());

        Graph g2 = new GraphImpl("g5.txt");
        HamiltonPath hl2 = new HamiltonPath(g2,1);
        System.out.println(hl2.hamiltonLoop());
    }

}

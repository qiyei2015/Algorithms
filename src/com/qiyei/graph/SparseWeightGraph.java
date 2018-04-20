package com.qiyei.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/4/15.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SparseWeightGraph<T extends Number & Comparable<T>> implements IWeightGraph{

    /**
     * 顶点个数
     */
    private int mV;
    /**
     * 边的个数
     */
    private int mE;
    /**
     * 是否为有向图
     */
    private boolean directed;
    /**
     * 邻接表
     */
    private List<Edge<T>>[] mG;


    public SparseWeightGraph(int n, boolean directed) {
        this.mV = n;
        this.mE = 0;
        this.directed = directed;
        mG = new List[n];
        for (int i = 0 ; i < n ; i++){
            mG[i] = new ArrayList<>();
        }
    }

    @Override
    public int V() {
        return mV;
    }

    @Override
    public int E() {
        return mE;
    }

    @Override
    public boolean isDirected() {
        return directed;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        if (!assertV(v) || !assertV(w)){
            return false;
        }

        //遍历，发现如果有等于w的节点就表示有边
        for (int i = 0 ; i < mG[v].size() ; i++){
            if (mG[v].get(i).other(v) == w){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addEdge(Edge edge) {
        if (!assertV(edge.getV()) || !assertV(edge.getW())){
            return;
        }

        //暂时不处理有平行边的问题

        //要除去自旋边的问题
        if (edge.getV() == edge.getW()){
            return;
        }
        //直接添加到list中就表示v连接了w
        mG[edge.getV()].add(edge);
        //无向图的话，也要添加，
        if (!directed){
            mG[edge.getW()].add(edge.mirrorEdge());
        }
        mE++;
    }

    @Override
    public Iterable<Edge<T>> adj(int v) {
        return mG[v];
    }

    /**
     * 判断n是否在顶点之内
     * @param n
     * @return
     */
    private boolean assertV(int n){
        if (n >= 0 && n < mV){
            return true;
        }
        return false;
    }

}

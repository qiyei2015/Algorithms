package com.qiyei.backup.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/4/8.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 稀疏图，用邻接表表示
 */
public class SparseGraph implements IGraph {
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
    private List<Integer>[] mG;

    /**
     * 构造一个图
     * @param n
     * @param directed
     */
    public SparseGraph(int n,boolean directed) {
        mV = n;
        mE = 0;
        mG = new List[n];
        this.directed = directed;
        for (int i = 0 ; i < n ; i++){
            mG[i] = new ArrayList<>();
        }
    }

    /**
     * 返回顶点数
     * @return
     */
    @Override
    public int V(){
        return mV;
    }

    /**
     * 返回边数
     * @return
     */
    @Override
    public int E(){
        return mE;
    }

    /**
     * 是否为有向图
     * @return
     */
    @Override
    public boolean isDirected(){
        return directed;
    }

    /**
     * 是否有边
     * @return
     */
    @Override
    public boolean hasEdge(int v,int w){
        if (!assertV(v) || !assertV(w)){
            return false;
        }

        //遍历，发现如果有等于w的节点就表示有边
        for (int i = 0 ; i < mG[v].size() ; i++){
            if (mG[v].get(i) == w){
                return true;
            }
        }
        return false;
    }

    /**
     * 在v,w之间添加一条边
     * @param v
     * @param w
     */
    @Override
    public void addEdge(int v,int w){
        if (!assertV(v) || !assertV(w)){
            return;
        }

        //暂时不处理有平行边的问题

        //要除去自旋边的问题
        if (v == w){
            return;
        }
        //直接添加到list中就表示v连接了w
        mG[v].add(w);
        //无向图的话，也要添加，
        if (!directed){
            mG[w].add(v);
        }
        mE++;
    }

    /**
     * 返回v相邻的顶点
     * @param v
     * @return
     */
    @Override
    public Iterable<Integer> adj(int v){
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

    /**
     * 判断n是否在边之内
     * @param n
     * @return
     */
    private boolean assertE(int n){
        if (n >= 0 && n < mE){
            return true;
        }
        return false;
    }
}

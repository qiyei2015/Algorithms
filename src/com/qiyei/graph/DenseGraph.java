package com.qiyei.graph;

/**
 * @author Created by qiyei2015 on 2018/4/8.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 稠密图 用邻接矩阵表示
 */
public class DenseGraph {

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
     * 邻接矩阵
     */
    private boolean[][] mG;

    /**
     * 构造图
     * @param n
     * @param directed
     */
    public DenseGraph(int n,boolean directed) {
        mV = n;
        mE = 0;
        mG = new boolean[n][n];
        this.directed = directed;
        for (int i = 0 ; i < n; i++){
            for (int j = 0 ; j < n ; j++){
                mG[i][j] = false;
            }
        }
    }

    /**
     * 返回顶点数
     * @return
     */
    public int V(){
        return mV;
    }

    /**
     * 返回边数
     * @return
     */
    public int E(){
        return mE;
    }

    /**
     * 是否为有向图
     * @return
     */
    public boolean isDirected(){
        return directed;
    }

    /**
     * 是否有边
     * @return
     */
    public boolean hasEdge(int v,int w){
        if (assertV(v) || assertV(w)){
            return false;
        }
        return mG[v][w];
    }

    /**
     * 在v,w之间添加一条边
     * @param v
     * @param w
     */
    public void addEdge(int v,int w){
        if (assertV(v) || assertV(w)){
            return;
        }

        //有边的话，就直接返回
        if (hasEdge(v,w)){
            return;
        }

        //赋值为true表示两个顶点存在边了
        mG[v][w] = true;
        //无向图的话，对称的点也需要赋值
        if (!directed){
            mG[w][v] = true;
        }
        mE++;
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

package com.qiyei.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/4/15.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 稠密有权图 用邻接矩阵表示
 */
public class DenseWeightGraph<T extends Number & Comparable<T>> implements IWeightGraph{

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
    private Edge<T>[][] mG;

    /**
     * 构造方法 使用邻接矩阵表示
     * @param v
     * @param directed
     */
    public DenseWeightGraph(int v, boolean directed) {
        this.mV = v;
        this.mE = 0;
        this.directed = directed;
        mG = new Edge[mV][mV];
        for (int i = 0 ; i < v; i++){
            for (int j = 0 ; j < v ; j++){
                mG[i][j] = null;
            }
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
        return mG[v][w] == null;
    }

    @Override
    public void addEdge(Edge edge) {
        if (!assertV(edge.getV()) || !assertV(edge.getW())){
            return;
        }

        //处理自选边的问题
        if (edge.getV() == edge.getW()){
            return;
        }

        //有边的话，就直接返回
        if (hasEdge(edge.getV(),edge.getW())){
            return;
        }

        //赋值为true表示两个顶点存在边了
        mG[edge.getV()][edge.getW()] = edge;
        //无向图的话，对称的点也需要赋值
        if (!directed){
            mG[edge.getW()][edge.getV()] = edge.mirrorEdge();
        }
        mE++;
    }

    @Override
    public T getWeight(int v, int w) {
        if (mG[v][w] != null){
            return mG[v][w].getWeight();
        }
        return null;
    }

    /**
     * 与其相邻的边
     * @param v
     * @return
     */
    @Override
    public Iterable<Edge<T>> adj(int v) {
        List<Edge<T>> list = new ArrayList<>();
        for (int i = 0 ; i < mV ; i++){
            if (mG[v][i] != null){
                list.add(mG[v][i]);
            }
        }
        return list;
    }

    @Override
    public Number getWeigthFor(int[] list) {
        return null;
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

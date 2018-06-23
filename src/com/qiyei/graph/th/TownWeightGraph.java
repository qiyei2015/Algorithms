package com.qiyei.graph.th;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/6/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class TownWeightGraph implements IWeightGraph<Town,Integer> {

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
    private boolean isDirected;
    /**
     * 图的邻接表
     */
    private List<Edge<Town,Integer>>[] mG;

    /**
     * 构造方法
     * @param n 结点个数
     * @param directed 是否为有向图
     */
    public TownWeightGraph(int n, boolean directed) {
        this.mV = n;
        this.mE = 0;
        this.isDirected = directed;
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
        return isDirected;
    }

    @Override
    public boolean hasEdge(Town v, Town w) {
        if (!assertV(v) || !assertV(w)){
            return false;
        }
        //遍历，发现如果有等于w的节点就表示有边
        for (int i = 0 ; i < mG[v.key()].size() ; i++){
            if (w.equals(mG[v.key()].get(i).other(v))){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addEdge(Edge<Town,Integer> edge) {
        if (!assertV(edge.getV()) || !assertV(edge.getW())){
            return;
        }

        //要除去自旋边的问题
        if (edge.getV().equals(edge.getW())){
            return;
        }
        //直接添加到list中就表示v连接了w
        mG[edge.getV().key()].add(edge);
        //无向图的话，也要添加，
        if (!isDirected){
            mG[edge.getW().key()].add(edge.mirrorEdge());
        }
        mE++;
    }

    @Override
    public Integer getWeight(Town v, Town w) {
        if (!assertV(v) || !assertV(w)){
            return null;
        }

        //遍历，发现如果有等于w的节点就表示有边，就返回对应的权值
        for (int i = 0 ; i < mG[v.key()].size() ; i++){
            if (mG[v.key()].get(i).other(v).equals(w)){
                return mG[v.key()].get(i).getWeight();
            }
        }
        return null;
    }

    @Override
    public Integer getWeightForPath(Town[] path) {
        int weight = 0;
        boolean reachable = true;
        if (path == null){
            return weight;
        }
        for (int i = 0 ; i < path.length - 1; i++){
            if (hasEdge(path[i],path[i+1])){
                Integer res = getWeight(path[i],path[i+1]);
                if (res != null){
                    weight += res;
                }
            }else {
                reachable = false;
            }
        }
        if (reachable){
            return weight;
        }else {
            return null;
        }
    }

    @Override
    public Iterable<Edge<Town,Integer>> adj(Town v) {
        if (!assertV(v)){
            return new ArrayList<>();
        }
        return mG[v.key()];
    }

    /**
     * 判断n是否在顶点之内
     * @param obj
     * @return
     */
    @Override
    public boolean assertV(Town obj){
        if (obj == null){
            throw new NullPointerException("params obj is null");
        }
        if (obj.key() >= 0 && obj.key() < mV){
            return true;
        }
        return false;
    }
}

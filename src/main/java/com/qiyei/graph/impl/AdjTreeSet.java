package com.qiyei.graph.impl;

import com.qiyei.graph.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Created by qiyei2015 on 2020/2/27.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class AdjTreeSet implements Graph {

    /**
     * 顶点数
     */
    private int V;

    /**
     * 边
     */
    private int E;
    /**
     * 红黑树数组
     */
    private TreeSet<Integer>[] mAdj;

    public AdjTreeSet(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)){
            V = scanner.nextInt();
            validateVertex(V);
            mAdj = new TreeSet[V];
            for (int i = 0 ; i < mAdj.length ; i++){
                mAdj[i] = new TreeSet<>();
            }
            E = scanner.nextInt();
            for (int i = 0; i < E ;i++){
                int v = scanner.nextInt();
                validateVertex(v);
                int w = scanner.nextInt();
                validateVertex(w);
                addEdge(v,w);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void validateVertex(int v) {
        if (v < 0 || v > V){
            throw new IllegalArgumentException(v + " is a IllegalArgument,must be in[0.." + V + "]");
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }


    @Override
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return mAdj[v].contains(w);
    }

    @Override
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        //忽略自旋边
        if (v == w){
            return;
        }
        //忽略平行边
        if (mAdj[v].contains(w)){
            return;
        }
        //添加边
        if (!isDirected()){
            mAdj[v].add(w);
            mAdj[w].add(v);
        } else {
            mAdj[v].add(w);
        }
    }

    @Override
    public void removeEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        if (mAdj[v].contains(w)){
            E--;
        }
        //移除边
        mAdj[v].remove(w);

        if (!isDirected()){
            if (mAdj[w].contains(v)){
                E--;
            }
            mAdj[w].remove(v);
        }
    }

    @Override
    public List<Integer> adj(int v) {
        validateVertex(v);
        List<Integer> list = new ArrayList<>();
        for (int w : mAdj[v]){
            list.add(w);
        }
        return list;
    }

    @Override
    public int degree(int v) {
        validateVertex(v);
        return adj(v).size();
    }


    @Override
    public AdjTreeSet clone(){
        AdjTreeSet clone = null;
        try {
            clone = (AdjTreeSet) super.clone();
            clone.mAdj = new TreeSet[clone.V()];
            for(int v = 0; v < V; v ++){
                clone.mAdj[v] = new TreeSet<Integer>();
                for(int w: mAdj[v])
                    clone.mAdj[v].add(w);
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for(int v = 0; v < V; v ++){
            sb.append(String.format("%d : ", v));
            for(int w : mAdj[v]){
                sb.append(String.format("%d ", w));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

}

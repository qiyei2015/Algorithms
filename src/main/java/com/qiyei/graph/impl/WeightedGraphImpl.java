package com.qiyei.graph.impl;

import com.qiyei.graph.WeightedGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Created by qiyei2015 on 2020/3/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 有权图具体实现
 */
public class WeightedGraphImpl<T extends Comparable> implements WeightedGraph<T> {

    /**
     * 顶点数
     */
    private int V;

    /**
     * 边
     */
    private int E;
    /**
     * key 为顶点，边的权值
     */
    private TreeMap<Integer,T>[] mAdj;


    public interface Convert<T>{
        T convert(int input);
    }

    public WeightedGraphImpl(String filename,Convert<T> convert) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)){
            V = scanner.nextInt();
            validateVertex(V);
            mAdj = new TreeMap[V];
            for (int i = 0 ; i < mAdj.length ; i++){
                mAdj[i] = new TreeMap<>();
            }
            E = scanner.nextInt();
            for (int i = 0; i < E ;i++){
                int v = scanner.nextInt();
                validateVertex(v);
                int w = scanner.nextInt();
                validateVertex(w);
                T weight = convert.convert(scanner.nextInt());
                addEdge(v,w,weight);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        return mAdj[v].containsKey(w);
    }

    @Override
    public void addEdge(int v, int w) {
        this.addEdge(v,w,null);
    }

    @Override
    public void addEdge(int v, int w, T weight) {
        if (weight == null){
            return;
        }
        validateVertex(v);
        validateVertex(w);
        //忽略自旋边
        if (v == w){
            return;
        }
        //忽略平行边
        if (mAdj[v].containsKey(w)){
            return;
        }
        //添加边
        if (!isDirected()){
            mAdj[v].put(w,weight);
            mAdj[w].put(v,weight);
        } else {
            mAdj[v].put(w,weight);
        }
    }

    @Override
    public void removeEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        if(mAdj[v].containsKey(w)) {
            E --;
        }
        //移除边
        mAdj[v].remove(w);
        if (!isDirected()){
            if (mAdj[w].containsKey(v)){
                E--;
            }
            mAdj[w].remove(v);
        }
    }

    @Override
    public List<Integer> adj(int v) {
        validateVertex(v);
        List<Integer> list = new ArrayList<>();
        for (int w : mAdj[v].keySet()){
            list.add(w);
        }
        return list;
    }

    @Override
    public int degree(int v) {
        validateVertex(v);
        return mAdj[v].size();
    }

    @Override
    public void validateVertex(int v) {
        if (v < 0 || v > V){
            throw new IllegalArgumentException(v + " is a IllegalArgument,must be in[0.." + V + "]");
        }
    }

    @Override
    public T getWeight(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return mAdj[v].get(w);
    }


    @Override
    public WeightedGraph<T> clone() {
        WeightedGraphImpl<T> clone = null;
        try {
            clone = (WeightedGraphImpl<T>) super.clone();
            clone.mAdj = new TreeMap[clone.V()];
            for(int v = 0; v < V; v ++){
                clone.mAdj[v] = new TreeMap<>();
                for(Map.Entry<Integer,T> entry: mAdj[v].entrySet()){
                    int w = entry.getKey();
                    T weight = entry.getValue();
                    clone.mAdj[v].put(w,weight);
                }
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
            for(Map.Entry<Integer,T> entry: mAdj[v].entrySet()){
                sb.append(String.format("%d:", entry.getKey()));
                sb.append(entry.getValue().toString());
                sb.append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WeightedGraph<Integer> weightedGraph = new WeightedGraphImpl<>("wg1.txt", new Convert<Integer>() {
            @Override
            public Integer convert(int input) {
                return input;
            }
        });

        System.out.println(weightedGraph.toString());
    }
}

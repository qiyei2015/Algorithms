package com.qiyei.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created by qiyei2015 on 2020/2/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 图的邻接矩阵表示
 */
public class AdjMatrix implements IGraph{
    /**
     * 顶点数
     */
    private int V;

    /**
     * 边
     */
    private int E;
    /**
     * 矩阵数组
     */
    private int[][] mAdj;

    public AdjMatrix(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)){
            V = scanner.nextInt();
            validateVertex(V);
            mAdj = new int[V][V];
            E = scanner.nextInt();
            for (int i = 0; i < E ;i++){
                int v = scanner.nextInt();
                int w = scanner.nextInt();
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
        return mAdj[v][w] == 1;
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
        if (mAdj[v][w] == 1){
            return;
        }
        //添加边
        if (!isDirected()){
            mAdj[v][w] = 1;
            mAdj[w][v] = 1;
        } else {
            mAdj[v][w] = 1;
        }
    }

    @Override
    public List<Integer> adj(int v) {
        validateVertex(v);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < V;i++){
            if (mAdj[v][i] == 1){
                list.add(i);
            }
        }
        return list;
    }

    @Override
    public int degree(int v) {
        return adj(v).size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for(int i = 0; i < V; i ++){
            for(int j = 0; j < V; j ++)
                sb.append(String.format("%d ", mAdj[i][j]));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IGraph graph = new AdjMatrix("g.txt");
        System.out.println(graph.toString());
    }
}

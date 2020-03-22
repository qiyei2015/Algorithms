package com.qiyei.graph.dfs;

import com.qiyei.graph.impl.GraphImpl;
import com.qiyei.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/3/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 * 求图的连通分量
 */
public class CCGraph {

    private Graph mGraph;
    /**
     * 记录某个订点的连通分量id ccid
     */
    private int[] mVisited;
    /**
     * 连通分量个数，也对应与连通分量id
     */
    private int count;

    public CCGraph(Graph graph) {
        mGraph = graph;
        mVisited = new int[mGraph.V()];
        for (int i = 0 ; i < mGraph.V() ; i++){
            mVisited[i] = -1;
        }
        for (int v = 0;  v < mGraph.V(); v++){
            if (mVisited[v] == -1){
                dfs(v,count);
                count++;
            }
        }
    }

    private void dfs(int v,int ccid){
        mVisited[v] = ccid;
        for (int w: mGraph.adj(v)){
            if (mVisited[w] == -1){
                dfs(w,ccid);
            }
        }
    }

    /**
     * 连通分量个数
     * @return
     */
    public int count(){
        return count;
    }

    /**
     * 任意两点是否相连
     * @param v
     * @param w
     * @return
     */
    public boolean isConnected(int v, int w){
        mGraph.validateVertex(v);
        mGraph.validateVertex(w);
        return mVisited[v] == mVisited[w];
    }

    /**
     * 所有的连通分量
     * @return
     */
    public List<Integer>[] components(){
        List[] res = new List[count];
        for (int i = 0 ; i < count ;i++){
            res[i] = new ArrayList();
        }
        for (int i = 0; i < mVisited.length ;i++){
            res[mVisited[i]].add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Graph graph = new GraphImpl("g2.txt");
        System.out.println(graph.toString());

        CCGraph ccGraph = new CCGraph(graph);
        System.out.println("count:" + ccGraph.count());
        System.out.println("connect:" + ccGraph.isConnected(1,4));
        System.out.println("connect:" + ccGraph.isConnected(2,5));
        List<Integer>[] res = ccGraph.components();

        for (int i = 0;i < res.length; i++){
            System.out.print(i+": ");
            for (int v : res[i]){
                System.out.print(v+" ");
            }
            System.out.println();
        }
    }
}

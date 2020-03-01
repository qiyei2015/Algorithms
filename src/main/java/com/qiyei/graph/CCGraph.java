package com.qiyei.graph;

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

    private IGraph mGraph;
    private int[] mVisited;
    private int count;

    public CCGraph(IGraph graph) {
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


    public int count(){
        return count;
    }

    public boolean isConnected(int v, int w){
        mGraph.validateVertex(v);
        mGraph.validateVertex(w);
        return mVisited[v] == mVisited[w];
    }

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
        IGraph graph = new Graph("g2.txt");
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

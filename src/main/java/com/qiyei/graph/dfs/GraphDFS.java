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
 */
public class GraphDFS {

    private Graph mGraph;

    /**
     * 是否被访问过
     */
    private boolean[] mVisited;
    /**
     * 遍历结果
     */
    private List<Integer> mOrder;


    public GraphDFS(Graph graph) {
        mGraph = graph;
        mVisited = new boolean[mGraph.V()];
        mOrder = new ArrayList<>();
    }

    public List<Integer> dfs(){
        mOrder.clear();
        for (int v = 0;  v < mGraph.V(); v++){
            if (!mVisited[v]){
                dfs(v);
            }
        }
        return mOrder;
    }

    /**
     * 递归的深度优先遍历
     * @param v
     */
    private void dfs(int v){
        mVisited[v] = true;
        mOrder.add(v);
        for (int w: mGraph.adj(v)){
            if (!mVisited[w]){
                dfs(w);
            }
        }
    }


    public static void main(String[] args) {
        Graph graph = new GraphImpl("g2.txt");
        GraphDFS graphDFS = new GraphDFS(graph);
        System.out.println(graphDFS.dfs());
    }
}

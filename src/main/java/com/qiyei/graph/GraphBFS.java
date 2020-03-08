package com.qiyei.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Created by qiyei2015 on 2020/3/8.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 * 广度优先遍历
 */
public class GraphBFS {

    private IGraph mGraph;

    /**
     * 是否被访问过
     */
    private boolean[] mVisited;
    /**
     * 遍历结果
     */
    private List<Integer> mOrder;


    public GraphBFS(IGraph graph) {
        mGraph = graph;
        mVisited = new boolean[mGraph.V()];
        mOrder = new ArrayList<>();
    }

    public List<Integer> bfs(){
        mOrder.clear();
        for (int v = 0;  v < mGraph.V(); v++){
            if (!mVisited[v]){
                bfs(v);
            }
        }
        return mOrder;
    }

    private void bfs(int v){
        mVisited[v] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        while (!queue.isEmpty()){
            Integer e = queue.poll();
            mOrder.add(e);
            for (int w:mGraph.adj(e)){
                if (!mVisited[w]){
                    mVisited[w] = true;
                    queue.add(w);
                }
            }
        }
    }


    public static void main(String[] args) {
        IGraph graph = new Graph("g2.txt");
        GraphBFS graphBFS = new GraphBFS(graph);
        System.out.println(graphBFS.bfs());
    }
}

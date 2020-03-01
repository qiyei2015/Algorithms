package com.qiyei.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/3/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class DFSGraph {

    private IGraph mGraph;

    /**
     * 是否被访问过
     */
    private boolean[] mVisited;
    /**
     * 遍历结果
     */
    private List<Integer> mDFSList;


    public DFSGraph(IGraph graph) {
        mGraph = graph;
        mVisited = new boolean[mGraph.V()];
        mDFSList = new ArrayList<>();
    }

    public List<Integer> dfs(){
        mDFSList.clear();
        for (int v = 0;  v < mGraph.V(); v++){
            if (!mVisited[v]){
                dfs(v);
            }
        }
        return mDFSList;
    }

    /**
     * 递归的深度优先遍历
     * @param v
     */
    private void dfs(int v){
        mVisited[v] = true;
        mDFSList.add(v);
        for (int w: mGraph.adj(v)){
            if (!mVisited[w]){
                dfs(w);
            }
        }
    }


    public static void main(String[] args) {
        IGraph graph = new Graph("g2.txt");
        DFSGraph dfsGraph = new DFSGraph(graph);
        System.out.println(dfsGraph.dfs());
    }
}

package com.qiyei.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/4/11.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 深度优先搜索 O(V+E) ？
 */
public class DepthFirstSerach {

    /**
     * 图
     */
    private IGraph mGraph;

    /**
     * marked[i]表示顶点i是否被标记
     */
    private boolean[] marked;

    /**
     * 图连通分量个数
     */
    private int cCount;

    /**
     * 深度优先遍历结果
     */
    private List<Integer> mdfsList;

    /**
     * id[i] 表示i属于哪一个连通分量
     */
    private int[] id;

    /**
     * 构造方法
     * @param mGraph
     */
    public DepthFirstSerach(IGraph mGraph) {
        this.mGraph = mGraph;
        marked = new boolean[mGraph.V()];
        id = new int[mGraph.V()];
        for (int i = 0 ;i < mGraph.V() ; i++){
            marked[i] = false;
            id[i] = -i+1;
        }
        cCount = -1;
        mdfsList = new ArrayList<>();
        //执行深度优先遍历
        dfs();
    }

    /**
     * 深度优先搜索，根据一个节点，不停的搜索预制相邻的节点，再继续搜索相邻节点的相邻节点，一直搜索下去
     */
    protected List<Integer> dfs(){
        for (int i = 0 ; i < mGraph.V() ; i++){
            //没有被访问过
            if (!marked[i]){
                dfs(mGraph,i);
                cCount++;
            }
        }
        return mdfsList;
    }

    /**
     * 返回连通分量个数
     * @return
     */
    public int count(){
        return cCount;
    }

    /**
     * 判断v,w是否相连，看是否属于同一个连通分量
     * @param v
     * @param w
     * @return
     */
    public boolean connect(int v,int w){
        return id[v] == id[w];
    }

    /**
     * 深度优先搜索
     * @param graph
     * @param i
     */
    private void dfs(IGraph graph, int i) {
        marked[i] = true;
        mdfsList.add(i);

        //使其i等于连通分量的值，这样属于同一个连通分量的点就有相同的连通分量
        id[i] = cCount;

        //遍历i的邻接点，依次进行深度优先遍历
        for (int j : graph.adj(i)){
            if (!marked[j]){
                dfs(graph,j);
            }
        }
    }
}

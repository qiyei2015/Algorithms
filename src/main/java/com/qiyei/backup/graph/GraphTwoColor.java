package com.qiyei.backup.graph;

/**
 * @author Created by qiyei2015 on 2018/7/2.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 判断是否是二分图
 */
public class GraphTwoColor {

    private boolean isTowColor = true;

    private boolean[] marked;

    private boolean[] color;

    public GraphTwoColor(IGraph graph) {
        marked = new boolean[graph.V()];
        color = new boolean[graph.V()];
        for (int i = 0;i < graph.V() ;i++){
            if (!marked[i]){
                dfs(graph,i);
            }
        }
    }

    private void dfs(IGraph graph,int v){
        marked[v] = true;
        for (int w: graph.adj(v)){
            if (!marked[w]){
                //颜色反转
                color[w] = !color[v];
                dfs(graph,w);
            }else if (color[w] == color[v]){
                //相邻节点颜色一样，不是二分图
                isTowColor = false;
            }
        }
    }

    /**
     * 是否是二分图
     * @return
     */
    public boolean isTowColor(){
        return isTowColor;
    }
}

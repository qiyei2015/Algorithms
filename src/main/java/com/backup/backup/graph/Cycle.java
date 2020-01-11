package com.backup.backup.graph;

/**
 * @author Created by qiyei2015 on 2018/7/2.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 判断图是否有环
 */
public class Cycle {

    private boolean isCycle;
    private boolean[] marked;

    /**
     * 构造方法
     * @param graph
     */
    public Cycle(IGraph graph) {
        marked = new boolean[graph.V()];
        for (int i = 0 ;i < graph.V();i++){
            if (!marked[i]){
                dfs(graph,i,i);
            }
        }
    }

    /**
     * dfs 有环的话，一定能从起点遍历到终点，并且二者相同
     * @param graph
     * @param source 起点
     * @param end 终点
     */
    private void dfs(IGraph graph,int source,int end){
        marked[source] = true;
        for (int w: graph.adj(source)){
            //没有被访问
            if (!marked[w]){
                dfs(graph,w,end);
            }else if (w != end){
                //已经被访问了,并且w != end，表示有环,被访问过了，说明从end有其他的路径到达w，因此构成一个环
                isCycle = true;
            }
        }
    }

    /**
     * 表示是否有环
     * @return
     */
    public boolean hasCycle(){
        return isCycle;
    }

}

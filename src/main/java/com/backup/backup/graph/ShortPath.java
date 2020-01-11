package com.backup.backup.graph;

import java.util.*;

/**
 * @author Created by qiyei2015 on 2018/4/12.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 使用广度优先遍历图
 */
public class ShortPath {

    /**
     * 图
     */
    private IGraph mGraph;
    /**
     * 源节点
     */
    private int source;
    /**
     * marked[i]表示顶点i是否被标记
     */
    private boolean[] marked;

    /**
     * from[i] 表示源节点到目标节点经过的节点
     */
    private int[] from;

    /**
     * 表示从s到目标节点的最短距离，即经过的节点个数
     */
    private int[] order;

    public ShortPath(IGraph graph, int s) {
        this.mGraph = graph;
        this.source = s;
        marked = new boolean[mGraph.V()];
        from = new int[mGraph.V()];
        order = new int[mGraph.V()];
        for (int i = 0 ;i < mGraph.V() ; i++){
            marked[i] = false;
            from[i] = -1;
            order[i] = -1;
        }
        //广度优先遍历
        bfs();
    }

    /**
     * 广度优先遍历，使用辅助结构队列
     */
    public void bfs(){
        //进行广度优先遍历 无向图的最短路径算法
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(source);
        marked[source] = true;
        order[source] = 0;
        while (!queue.isEmpty()){
            //出队
            int p = queue.poll();

            //将p的所有相邻的顶点加入队列
            for (Integer i : mGraph.adj(p)){
                if (!marked[i]){
                    //标记i被访问过
                    marked[i] = true;
                    //记录i的order
                    order[i] = order[p] + 1;
                    //标记i的节点是从p访问过来的
                    from[i] = p;
                    queue.add(i);
                }
            }
        }
    }

    /**
     * 源节点source 到目标节点是否有路径
     * @param w
     * @return
     */
    public boolean hasPath(int w){
        //查看w是否被访问了,如果被访问了就表示肯定有路径到达
        return marked[w];
    }

    /**
     * 到目标节点的path路径
     * @param w
     * @return
     */
    public List<Integer> path(int w){
        List<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        //从w开始到推from数组,最开始的原点是-1,为循环结束条件
        int p = w;
        while (p != -1){
            //最先入栈的是w,接下来是from[w]这个节点
            stack.push(p);
            //from[p]找到上一个节点
            p = from[p];
        }

        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 打印到目标节点的路径
     * @param w
     */
    public void showPath(int w){
        List<Integer> list = path(w);
        for (int i = 0 ; i < list.size() ; i++){
            System.out.print(list.get(i));
            if (i != list.size() - 1){
                System.out.print(" -> ");
            }
        }
        System.out.println("");
    }

    /**
     * source到w的路径的距离
     * @param w
     * @return
     */
    public int length(int w){
        return order[w];
    }

}

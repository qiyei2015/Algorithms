package com.qiyei.graph;

import com.qiyei.graph.dfs.CCGraph;
import com.qiyei.graph.impl.GraphImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by qiyei2015 on 2020/3/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 欧拉路径
 */
public class EulerLoop {

    private Graph mGraph;

    /**
     * 遍历结果
     */
    private List<Integer> mOrder;

    public EulerLoop(Graph graph) {
        mGraph = graph;
        mOrder = new ArrayList<>();
    }

    /**
     * 是否有欧拉路径
     * @return
     */
    public boolean hasEulerLoop(){
        CCGraph ccGraph = new CCGraph(mGraph);
        if (ccGraph.count() > 1){
            return false;
        }
        for (int v = 0 ; v < mGraph.V() ;v++){
            if (mGraph.degree(v) % 2 == 1){
                return false;
            }
        }
        return true;
    }

    /**
     * 查找欧拉路径
     * @return
     */
    public List<Integer> findEulerLoop(){
        mOrder.clear();
        if (!hasEulerLoop()){
            return mOrder;
        }

        Graph graph = mGraph.clone();
        if (graph == null){
            return mOrder;
        }
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        stack.push(0);
        while (!stack.isEmpty()){
            if (graph.degree(cur) != 0){
                stack.push(cur);
                //获取相邻的顶点
                int w = graph.adj(cur).iterator().next();
                //删除与相邻的顶点的边
                graph.removeEdge(cur,w);
                cur = w;
            } else {
                mOrder.add(cur);
                cur = stack.pop();
            }
        }
        return mOrder;
    }

    public static void main(String[] args) {
        Graph g = new GraphImpl("g6.txt");
        EulerLoop el = new EulerLoop(g);
        System.out.println(el.findEulerLoop());

        Graph g2 = new GraphImpl("g7.txt");
        EulerLoop el2 = new EulerLoop(g2);
        System.out.println(el2.findEulerLoop());
    }
}

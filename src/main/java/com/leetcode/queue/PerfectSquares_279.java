package com.leetcode.queue;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Created by qiyei2015 on 2018/6/2.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 279. 完全平方数
 */
public class PerfectSquares_279 {

    static class Node{
        int value;
        int step;

        public Node(int value, int step) {
            this.value = value;
            this.step = step;
        }
    }

    /**
     * 使用队列 建立无权图，求最短路径 BFS
     * @param n
     * @return
     */
    public int numSquares(int n) {
        Queue<Node> queue = new ArrayDeque<>();
        //表示每个结点是否被访问
        boolean[] visit = new boolean[n + 1];

        queue.add(new Node(n,0));
        visit[n] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            for (int i = 1;;i++){
                int k = node.value - i*i;
                if (k < 0){
                    break;
                }
                if (k == 0){
                    return node.step + 1;
                }
                //还能承受一个完全平方数，并且没有被访问
                if (k > 0 && !visit[k]){
                    visit[k] = true;
                    queue.add(new Node(k,node.step + 1));
                }
            }
        }

        return -1;
    }

}

package com.qiyei.unionfind;

/**
 * @author Created by qiyei2015 on 2018/4/6.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class UnionFind {
    /**
     * 每个元素i的根节点
     */
    private int[] parent;
    /**
     * 元素个数
     */
    private int count;

    public UnionFind(int size) {
        parent = new int[size];
        count = size;
        for (int i = 0 ; i < count ; i++){
            parent[i] = i;
        }
    }

    /**
     * 返回p的根节点
     * @param p
     * @return
     */
    public int find(int p){
        if (p >= 0 && p <= count){
            while (p != parent[p]){
                p = parent[p];
            }
        }
        return p;
    }

    /**
     * 判断 p q时候相连
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    /**
     * 将两个结点连接
     * @param p
     * @param q
     */
    public void union(int p,int q){
        if (p >= count || q >= count){
            return;
        }
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        //将p的根指向q的根
        parent[pRoot] = qRoot;
    }


}

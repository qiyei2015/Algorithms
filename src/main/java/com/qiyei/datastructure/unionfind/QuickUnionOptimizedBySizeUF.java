package com.qiyei.datastructure.unionfind;

/**
 * @author Created by qiyei2015 on 2019/12/12.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 快速连接并查集 基于Size的优化
 * 使用size[]数组记录每个结点的元素个数，连接时将多的个数结点连接到小的个数结点的上
 */
public class QuickUnionOptimizedBySizeUF implements UF{

    /**
     * 每个索引对应的值存储是的父结点的集合编号
     * 即parent[i]表示第i个元素所指向的父节点
     */
    private int[] parent;
    /**
     * 存储每个索引所代表的集合所对应的元素个数
     */
    private int[] size;

    public QuickUnionOptimizedBySizeUF(int size) {
        parent = new int[size];
        this.size = new int[size];
        for (int i = 0 ;i < size;i++){
            // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
            parent[i] = i;
            this.size[i] = 1;
        }
    }

    @Override
    public int size() {
        return parent.length;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot){
            return;
        }

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if (size[pRoot] < size[qRoot]){
            //将p父结点的根节点指向q的父结点即可
            parent[pRoot] = qRoot;
            //更新qRoot集合中元素个数
            size[qRoot] += size[pRoot];
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }

    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 找寻结点p的父结点的编号
     * O(h)复杂度, h为树的高度
     * @param p
     * @return
     */
    private int find(int p){
        if (p < 0 || p >= parent.length){
            throw new IllegalArgumentException("IllegalArgument for " + p);
        }
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

}

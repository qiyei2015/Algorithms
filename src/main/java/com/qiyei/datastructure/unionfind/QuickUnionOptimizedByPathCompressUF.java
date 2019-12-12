package com.qiyei.datastructure.unionfind;

/**
 * @author Created by qiyei2015 on 2019/12/12.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 快速连接并查集 基于Rank的优化
 *  连接时将rank低的集合合并到rank高的集合上，并进行路径压缩
 */
public class QuickUnionOptimizedByPathCompressUF implements UF{

    /**
     * 每个索引对应的值存储是的父结点的集合编号
     * 即parent[i]表示第i个元素所指向的父节点
     */
    private int[] parent;
    /**
     * 在后续的代码中, 我们并不会维护rank的语意, 也就是rank的值在路径压缩的过程中, 有可能不在是树的层数值
     * 这也是我们的rank不叫height或者depth的原因, 他只是作为比较的一个标准
     */
    private int[] rank;

    public QuickUnionOptimizedByPathCompressUF(int size) {
        parent = new int[size];
        this.rank = new int[size];
        for (int i = 0 ;i < size;i++){
            // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
            parent[i] = i;
            this.rank[i] = 1;
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

        // 根据两个元素所在树的层数不同判断合并方向
        // 将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]){
            //将p父结点的根节点指向q的父结点即可
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        } else {
            //层数一样
            parent[pRoot] = qRoot;
            rank[qRoot]++;
        }

    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /** compress
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
            //更改p的父结点的索引
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}

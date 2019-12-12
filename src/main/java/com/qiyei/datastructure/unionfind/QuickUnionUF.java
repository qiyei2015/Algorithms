package com.qiyei.datastructure.unionfind;

/**
 * @author Created by qiyei2015 on 2019/12/11.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 快速连接并查集
 * 将每个元素看成一个结点，每个结点指向父结点。由于有很多根节点，严格来说是一个森林
 * 用数组表示每个结点，存储的是父结点的索引。根节点指向自己
 */
public class QuickUnionUF implements UF{

    /**
     * 每个索引对应的值存储是的父结点的集合编号
     * 即parent[i]表示第i个元素所指向的父节点
     */
    private int[] parent;

    public QuickUnionUF(int size) {
        parent = new int[size];
        for (int i = 0 ;i < size;i++){
            // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
            parent[i] = i;
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
        //将p父结点的根节点指向q的父结点即可
        parent[pRoot] = qRoot;
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

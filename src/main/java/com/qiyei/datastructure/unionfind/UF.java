package com.qiyei.datastructure.unionfind;

/**
 * @author Created by qiyei2015 on 2019/12/11.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: UnionFind并查集接口定义
 */
public interface UF {

    /**
     * 集合元素个数
     * @return
     */
    int size();

    /**
     * 将两个元素连接，加入相同的集合
     * @param p
     * @param q
     */
    void union(int p,int q);

    /**
     * p与q是否相连，查看是否属于同一个集合
     * @return
     */
    boolean connected(int p, int q);
}

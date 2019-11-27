package com.qiyei.unionfind;

/**
 * @author Created by qiyei2015 on 2018/3/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: quick find
 */
public class UnionFind1 {
    private int[] id;
    private int count;

    public UnionFind1(int n) {
        id = new int[n];
        count = n;
        for (int i = 0 ; i < n ; i++){
            id[i] = i;
        }
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
        int pId = find(p);
        int qId = find(q);
        if (pId == qId){
            return;
        }
        for (int i = 0 ; i < count ;i++){
            if (pId == id[i]){
                id[i] = qId;
            }
        }
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    /**
     * 返回结点大小
     * @return
     */
    public int count(){
        return count;
    }

    /**
     * 查找p结点
     * @param p
     * @return
     */
    public int find(int p){
        return id[p];
    }

}

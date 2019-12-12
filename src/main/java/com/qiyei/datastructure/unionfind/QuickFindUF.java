package com.qiyei.datastructure.unionfind;

/**
 * @author Created by qiyei2015 on 2019/12/11.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 快速查询的并查集
 * 用数组来存储，每个索引对应的是集合的编号
 */
public class QuickFindUF implements UF{

    /**
     * 元素集合
     */
    private int[] id;

    public QuickFindUF(int size) {
        id = new int[size];
        //分别属于不同的集合
        for (int i = 0 ;i < id.length; i++){
            id[i] = i;
        }
    }

    @Override
    public int size() {
        return id.length;
    }

    /**
     * 时间复杂度O(n)
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int idP = find(p);
        int idQ = find(q);

        //已经是同一个集合了
        if (idP == idQ){
            return;
        }

        for (int i = 0 ;i < id.length ;i++){
            //将所有在idP的集合中的元素与idQ一起合并
            if (id[i] == idP){
                id[i] = idQ;
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 找到元素所p在集合编号
     * @param p
     * @return
     */
    private int find(int p){
        if (p < 0 || p > id.length){
            throw new IllegalArgumentException("IllegalArgument for " + p);
        }
        return id[p];
    }
}

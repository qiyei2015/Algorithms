package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/6/10.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 77. 组合
 */
public class Combinations {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        list.clear();

        if (n <= 0 || k <= 0 || k > n){
            return list;
        }
        findCombile(n,k,1,new LinkedList<Integer>());
        return list;
    }

    /**
     * C(n,k)问题，从start开始找
     * @param n
     * @param k
     * @param start
     * @param res
     */
    private void findCombile(int n, int k, int start,LinkedList<Integer> res){

        if (res.size() == k){
            list.add((LinkedList<Integer>)res.clone());
            return;
        }

        for (int i = start ;i <= n;i++){
            res.addLast(i);
            findCombile(n,k,i+1,res);
            res.removeLast();
        }
    }


}

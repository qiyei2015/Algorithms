package com.qiyei.unionfind;

import com.qiyei.util.LogUtil;
import com.qiyei.util.StopWatch;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/3/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class UnionFindTest {

    private static final int SIZE = 8000;


    public static void main(String[] args){

        UnionFind1 unionFind1 = new UnionFind1(1000000);
        UnionFind unionFind = new UnionFind(1000000);
        Random random = new Random();

        for (int i = 0 ;i < SIZE ;i++){
            int p = random.nextInt(SIZE);
            int q = random.nextInt(SIZE);
            if (p == q){
                continue;
            }
            unionFind1.union(p,q);
            unionFind.union(p,q);
        }

        LogUtil.println("unionfind test:" + test(unionFind));
        LogUtil.println("unionfind1 test:" + test1(unionFind1));

    }


    private static double test1(UnionFind1 unionFind1){
        StopWatch stopWatch = new StopWatch(2);
        for (int i = 0 ;i < SIZE ;i++){
//            LogUtil.println(i + " " + (i+5) + " is connect:" + unionFind1.connected(i,i+5));
            unionFind1.connected(i,i+5);
        }
        return stopWatch.elapsedTimeMilli();
    }

    private static double test(UnionFind unionFind){
        StopWatch stopWatch = new StopWatch(2);
        for (int i = 0 ;i < SIZE ;i++){
//            LogUtil.println(i + " " + (i+5) + " is connect:" + unionFind.connected(i,i+5));
            unionFind.connected(i,i+5);
        }
        return stopWatch.elapsedTimeMilli();
    }
}

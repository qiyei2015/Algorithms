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
        UnionFind2 unionFind2 = new UnionFind2(1000000);
        UnionFind3 unionFind3 = new UnionFind3(1000000);


        LogUtil.println("unionfind1 test:" + test1(unionFind1) + " s");
        LogUtil.println("unionfind2 test:" + test(unionFind2) + " s");
        LogUtil.println("unionfind3 test:" + test(unionFind3) + " s");

    }


    private static double test1(UnionFind1 unionFind1){
        StopWatch stopWatch = new StopWatch();
        Random random = new Random();
        for (int i = 0 ;i < SIZE ;i++){
            int p = random.nextInt(SIZE);
            int q = random.nextInt(SIZE);
            if (p == q){
                continue;
            }
            unionFind1.union(p,q);
        }

        for (int i = 0 ;i < SIZE ;i++){
            unionFind1.connected(i,i+5);
        }
        return stopWatch.elapsedTime();
    }

    private static double test(UnionFind2 unionFind){
        StopWatch stopWatch = new StopWatch();

        Random random = new Random();
        for (int i = 0 ;i < SIZE ;i++){
            int p = random.nextInt(SIZE);
            int q = random.nextInt(SIZE);
            if (p == q){
                continue;
            }
            unionFind.union(p,q);
        }
        for (int i = 0 ;i < SIZE ;i++){
            unionFind.connected(i,i+5);
        }
        return stopWatch.elapsedTime();
    }


    private static double test(UnionFind3 unionFind){
        StopWatch stopWatch = new StopWatch();

        Random random = new Random();
        for (int i = 0 ;i < SIZE ;i++){
            int p = random.nextInt(SIZE);
            int q = random.nextInt(SIZE);
            if (p == q){
                continue;
            }
            unionFind.union(p,q);
        }
        for (int i = 0 ;i < SIZE ;i++){
            unionFind.connected(i,i+5);
        }
        return stopWatch.elapsedTime();
    }
}

package com.qiyei.unionfind;

import com.qiyei.util.LogUtil;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/3/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class UnionFindTest {
    
    public static void main(String[] args){

        UnionFind1 unionFind1 = new UnionFind1(100);
        Random random = new Random();

        for (int i = 0 ;i < 80 ;i++){
            int p = random.nextInt(100);
            int q = random.nextInt(100);
            if (p == q){
                continue;
            }
            unionFind1.union(p,q);
        }

        for (int i = 0 ;i < 80 ;i++){
            int p = random.nextInt(100);
            int q = random.nextInt(100);
            if (p == q){
                continue;
            }
            LogUtil.println(p + " " + q + " is connect:" + unionFind1.connected(p,q));
        }

    }

}

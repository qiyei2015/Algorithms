package com.backup.backup.st;

import com.backup.backup.util.LogUtil;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/5/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class STTest {


    public static void main(String[] args){
        SequentialSerachST<Integer,String> integerStringSequentialSerachST = new SequentialSerachST<>();

        Random random = new Random();

        for (int i = 0 ; i < 100; i++){
            integerStringSequentialSerachST.put(i," A_" + random.nextInt(100));
        }
        LogUtil.println("size:" + integerStringSequentialSerachST.size());
        LogUtil.println("min:" + integerStringSequentialSerachST.min() + " max:" + integerStringSequentialSerachST.max());
        for (Integer integer : integerStringSequentialSerachST.keys()){
            LogUtil.println("key:" + integer + " value:" + integerStringSequentialSerachST.get(integer));
        }

    }
}

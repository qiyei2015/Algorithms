package com.qiyei.tree;

import com.qiyei.util.LogUtil;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/4/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class TreeTest {



    public static void main(String[] args){
        BST<Integer,String> integerStringBST = new BST<>();
        Random random = new Random();

        for (int i = 0 ; i < 100 ;i++){
            int p = random.nextInt(100);
            integerStringBST.insert(p,"message " + p);
        }

        LogUtil.println("integerStringBST size:" + integerStringBST.size());
        LogUtil.println("integerStringBST size:" + integerStringBST.contains(4));
        integerStringBST.inOrder();
        LogUtil.println("");
        integerStringBST.preOrder();
    }

}

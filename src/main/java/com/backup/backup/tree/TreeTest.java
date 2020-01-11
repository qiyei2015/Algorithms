package com.backup.backup.tree;

import com.backup.backup.util.LogUtil;

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
//        integerStringBST.preOrder();
        LogUtil.println("");
//        integerStringBST.levelOrder();

        LogUtil.println("min:" + integerStringBST.minimum() + "  Max:" + integerStringBST.maximum());
        integerStringBST.removeMin();
        integerStringBST.removeMax();
        integerStringBST.inOrder();
        LogUtil.println("");
        LogUtil.println("integerStringBST size:" + integerStringBST.size());

        integerStringBST.remove(12);
        LogUtil.println("integerStringBST size:" + integerStringBST.size());
        integerStringBST.inOrder();
    }

}

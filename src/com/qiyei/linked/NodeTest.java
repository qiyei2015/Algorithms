package com.qiyei.linked;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/4/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class NodeTest {

    public static void main(String[] args){

        Random random = new Random();

        NodeList<Integer> nodeList = new NodeList<>();

        for (int i = 0 ; i < 100; i++){
            nodeList.addNode(i);
        }

        nodeList.show(nodeList.getNodeList());

        nodeList.show(nodeList.reverse());

        nodeList.show(nodeList.reverse2());

    }
}

package com.qiyei.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/4/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class NodeTest {

    public static void main(String[] args){

        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();

        for (int i = 0 ; i < 100; i++){
            singleLinkedList.addNode(i);
        }

        singleLinkedList.show(singleLinkedList.getNodeList());

        singleLinkedList.show(singleLinkedList.reverse());

        singleLinkedList.show(singleLinkedList.reverse2());

    }
}

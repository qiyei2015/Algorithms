package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 92. 反转链表 II
 */
public class ReverseLinkedListBetween {


    /**
     * 反转指定区间链表
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode newHead = null;
        ListNode newCur = newHead;//

        ListNode cur = head;//当前结点

        int k = 0;

        //找到新节点
        while (cur != null){
            k++;
            if (k == m){
                newCur = cur;
            }
        }

        return null;
    }

}

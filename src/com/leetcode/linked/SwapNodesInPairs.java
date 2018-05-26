package com.leetcode.linked;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 24
 */
public class SwapNodesInPairs {

    /**
     * 两两交换
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;

        while (p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            //两两交换
            node2.next = node1;
            node1.next = next;
            p.next = node2;

            //更新结点
            p = node1;
        }

        ListNode retNode = dummyHead.next;
        dummyHead.next = null;

        return retNode;
    }


    /**
     * 两两交换
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;

        while (p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;


            //两两交换
            node2.next = node1;
            node1.next = p.next.next.next;
            p.next = node2;

            //更新结点
            p = node1;
        }

        ListNode retNode = dummyHead.next;
        dummyHead.next = null;

        return retNode;
    }
}

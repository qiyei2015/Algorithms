package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/6/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 查找链表中位结点
 */
public class FindLinkedMedianNode {

    /**
     * 查找链表中位结点
     * @param head
     * @return
     */
    public ListNode findMedianNode(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        //fast每次比slow多跑一步
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            //跑2步
            fast = fast.next.next;
        }

        slow.next = null;

        return slow;
    }

}

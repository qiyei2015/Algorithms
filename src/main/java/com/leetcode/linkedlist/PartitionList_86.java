package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 86
 * https://leetcode-cn.com/problems/partition-list/
 */
public class PartitionList_86 {

    public ListNode partition(ListNode head, int x) {

        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode p1 = dummyHead1;
        ListNode p2 = dummyHead2;

        while (head != null){
            if (head.val < x){
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }

        p2.next = null;
        p1.next = dummyHead2.next;
        return dummyHead1.next;
    }


}

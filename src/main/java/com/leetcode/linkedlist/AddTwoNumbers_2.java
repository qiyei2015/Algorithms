package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 2
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        int value = 0;

        while (p1 != null || p2 != null){
            //新建结点
            ListNode node = null;

            if (p1 == null){
                value = p2.val + value;
                node = new ListNode(value % 10);
                p2 = p2.next;

            } else if (p2 == null){
                value = p1.val + value;
                node = new ListNode(value % 10);
                p1 = p1.next;
            } else {
                value = p1.val + p2.val + value;
                node = new ListNode(value % 10);
                p1 = p1.next;
                p2 = p2.next;
            }

            p.next = node;
            //更新p
            p = p.next;
            //进位
            value = value / 10;
        }

        if (value > 0){
            //新建结点
            ListNode node = new ListNode(value);
            p.next = node;
        }

        return dummyHead.next;
    }
}

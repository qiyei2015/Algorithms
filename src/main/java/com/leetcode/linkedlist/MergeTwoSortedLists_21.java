package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2020/1/14.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 21
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null || p2 != null){

            if (p1 == null){
                //取p2
                ListNode node = new ListNode(p2.val);
                cur.next = node;

                //更新p2
                p2 = p2.next;
            } else if (p2 == null){
                //取p1
                ListNode node = new ListNode(p1.val);
                cur.next = node;

                //更新p2
                p1 = p1.next;
            } else if (p1 != null && p2 != null && p1.val < p2.val){
                //取p1
                ListNode node = new ListNode(p1.val);
                cur.next = node;

                //更新p2
                p1 = p1.next;
            } else if (p1 != null && p2 != null && p2.val <= p1.val){
                //取p2
                ListNode node = new ListNode(p2.val);
                cur.next = node;

                //更新p2
                p2 = p2.next;
            }

            //更新cur
            cur = cur.next;
        }

        return dummyHead.next;

    }


}

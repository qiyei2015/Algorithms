package com.leetcode.linked;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 206. 反转链表
 */
public class ReverseLinkedList {

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;//前置结点
        ListNode cur = head;//当前结点

        while (cur != null){
            ListNode next = cur.next;

            //反转链表,反向指
            cur.next = prev;
            //更新指针
            prev = cur;
            cur = next;
        }

        return prev;
    }

}

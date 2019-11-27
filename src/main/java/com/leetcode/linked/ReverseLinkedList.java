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

    /**
     * 递归方式 递归的方法其实是非常巧的，它利用递归走到链表的末端，然后再更新每一个node的next 值 ，实现链表的反转。
     * 而newhead 的值没有发生改变，为该链表的最后一个结点，所以，反转后，我们可以得到新链表的head
     * @param p
     * @return
     */
    public ListNode reverseList2(ListNode p){
        if (p == null || p.next == null){
            //只有一个结点或者为null
            return p;
        }

        //递归找到最后一个结点
        ListNode newHead = reverseList2(p.next);
        //递归回来 当前p.next.next = null ，说明p 是倒数第二个结点，p.next是倒数第一个结点
        // 将最后一个结点指向倒数第二个结点
        p.next.next = p;
        //p的下一个指向为null
        p.next = null;

        return newHead;
    }

}

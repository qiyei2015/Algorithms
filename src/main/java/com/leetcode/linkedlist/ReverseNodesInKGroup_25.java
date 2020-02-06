package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2020/1/14.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 25
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup_25 {


    /**
     * 将要反转的结点拆开
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        //1单独处理
        if (k == 1){
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        //设置前置头结点
        ListNode prevHead = dummyHead;

        //当前遍历结点
        ListNode cur = head;
        ListNode next = null;

        //新结点
        ListNode newHead = null;
        ListNode tail = null;

        int i = 1;

        while (cur != null){
            //开始反转
            if (i == k){
                i = 1;

                //暂存next
                next = cur.next;

                //断开指向，便于后续反转
                cur.next = null;
                prevHead.next = null;

                //反转
                tail = newHead;
                newHead = reverseList(newHead);

                //指向新head
                prevHead.next = newHead;

                //更新
                prevHead = tail;
                cur = next;
            } else {
                if (i == 1){
                    newHead = cur;
                }
                i++;
                cur = cur.next;
            }
        }

        //后面有剩下的
        if (k != 1 && next != null){
            prevHead.next = next;
        }

        return dummyHead.next;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
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

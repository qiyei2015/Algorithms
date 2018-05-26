package com.leetcode.linked;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 19
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 使用双索引技术
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 0){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        for (int i = 0 ;i < n+1 ;i++){
            if (q != null){
                q = q.next;
            }
        }

        //向后移动到q==null
        while (q != null){
            q = q.next;
            p = p.next;
        }

        //找到删除的节点了p.next
        ListNode delNode = p.next;
        p.next = delNode.next;
        delNode.next = null;

        ListNode retNode = dummyHead.next;
        dummyHead.next = null;
        return retNode;
    }

}

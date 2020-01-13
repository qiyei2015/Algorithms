package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 83 删除链表重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromList_83 {

    /**
     * 删除重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;

            if (prev != null && prev.val == cur.val){
                //删除当前结点
                prev.next = next;
                cur = cur.next;
                continue;
            }
            //更新结点
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur;

        while (cur != null){
            next = cur.next;

            if (prev != null && prev.val == cur.val){
                //删除当前结点，置null
                cur = null;
                //前一个结点直接指向下一个结点
                prev.next = next;
                //更新cur下一个结点
                cur = next;

                continue;
            }
            //更新结点
            prev = cur;
            cur = next;
        }
        return head;
    }

}

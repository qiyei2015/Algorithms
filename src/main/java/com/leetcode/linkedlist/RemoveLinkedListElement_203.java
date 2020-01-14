package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 203 删除链表中的节点
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElement_203 {


    /**
     * 删除链表中指定值为val的节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        //设置虚拟头结点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null){
            //cur.next就是要删除的节点
            if (cur.next.val == val){
                ListNode delNode = cur.next;
                //cur 指向下一个的下一个结点
                cur.next = cur.next.next;
                delNode.next = null;

            }else {
                cur = cur.next;
            }
        }

        ListNode retNode = dummyHead.next;
        //释放虚拟头结点
        dummyHead.next = null;
        return retNode;
    }


    /**
     * 删除链表中指定的节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        //删除头结点中的元素
        while (head != null && head.val == val){
            ListNode delNode = head;
            head = delNode.next;
            delNode.next = null;
        }
        if (head == null){
            return null;
        }

        ListNode cur = head;
        while (cur.next != null){
            //cur.next就是要删除的节点
            if (cur.next.val == val){
                ListNode delNode = cur.next;
                //cur 指向下一个的下一个结点
                cur.next = cur.next.next;
                delNode.next = null;

            }else {
                cur = cur.next;
            }
        }
        return head;
    }



}

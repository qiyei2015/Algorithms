package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2020/1/14.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SortList_148 {

    /**
     * 使用快速排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        ListNode end = head;
        while (end != null){
            end = end.next;
        }
        return quickSortList(head,end);
    }

    private ListNode quickSortList(ListNode start,ListNode end) {
        if (start == null){
            return end;
        }
        if (end == null){
            return start;
        }

        int val  = start.val;
        ListNode node = partition(start,val);
        ListNode ret = quickSortList(start,node);
        quickSortList(node.next,end);
        return ret;
    }


    private ListNode partition(ListNode head, int x) {

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

    /**
     * 自底向上归并
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        //应该遍历
        ListNode[] count = new ListNode[64];
        ListNode cur = head;

        int maxIndex = 0;
        while (cur != null){

            ListNode p = cur;
            cur = cur.next;

            //断开p的链接
            p.next = null;

            int i = 0;
            while (count[i] != null){
                p = merge(p,count[i]);
                count[i] = null;

                i++;
            }

            count[i] = p;
            if (i > maxIndex){
                maxIndex = i;
            }
        }

        ListNode res = null;
        for (int i = 0 ;i <= maxIndex;i++){
            if (count[i] != null){
                res = merge(res,count[i]);
            }
        }
        return res;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        if (l1.val < l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        } else {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}

package com.whu.LC141_150;

import com.whu.ListNode;

public class LC148 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

//            找到中间节点
            ListNode slow = head;
            ListNode fast = head;
            ListNode pre = null;//断开链表
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

//            分割链表
            pre.next = null;

            ListNode left = sortList(head);
            ListNode right = sortList(slow);

            return mergeTwoLists(left, right);
        }

        private ListNode mergeTwoLists(ListNode left, ListNode right) {
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;

            while (left != null && right != null) {
                if (left.val <= right.val) {
                    tail.next = left;
                    left = left.next;
                } else {
                    tail.next = right;
                    right = right.next;
                }
                tail = tail.next;
            }

            tail.next = (left != null) ? left : right;

            return dummyHead.next;
        }
    }
}

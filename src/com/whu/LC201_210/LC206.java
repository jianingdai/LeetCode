package com.whu.LC201_210;

import com.whu.ListNode;

public class LC206 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
//                链表为空或者只有一个节点不用反转
                return head;
            }

            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }
    }
}

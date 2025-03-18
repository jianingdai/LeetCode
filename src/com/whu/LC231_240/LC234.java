package com.whu.LC231_240;

import com.whu.ListNode;

import java.util.HashMap;

public class LC234 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;//空链表或者只有一个节点的链表是回文
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode pre = null;
            ListNode current = slow.next;
            while (current != null) {
                ListNode next = current.next;
                current.next = pre;
                pre = current;
                current = next;
            }

            slow.next = pre;

            ListNode p1 = head;
            ListNode p2 = slow.next;

            boolean isPalindrome = true;
            while (p2 != null) {
                if (p1.val != p2.val) {
                    isPalindrome = false;
                    break;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return isPalindrome;
        }
    }
}

package com.whu.LC11_20;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LC19 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static class Solution {
        //        删除倒数第n个结点
        public ListNode removeNthFromEnd(ListNode head, int n) {
//            添加一个虚结点放在head前面
            ListNode dummy = new ListNode(0, head);
//            用p当指针来指向以head为1的第n个节点
            ListNode p = head;
            ListNode now = head;
            for (int i = 0; i < n - 1; i++) {
//                将p移动
                p = p.next;
            }
            while (p.next != null) {
                dummy = dummy.next;
                now = now.next;
                p = p.next;
            }
//            *
//            0->1
            if (dummy.next == head) {
                head = head.next;
            } else {
                dummy.next = now.next;
            }
            return head;
        }
    }
}

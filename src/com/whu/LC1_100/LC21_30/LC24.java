package com.whu.LC1_100.LC21_30;

public class LC24 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public ListNode swapPairs(ListNode node) {
            if (node == null || node.next == null) {
//                当链表中只有一个节点或者没有节点的时候返回
                return node;
            }
            ListNode next = node.next;
            node.next = swapPairs(next.next);
            next.next = node;
            return next;
        }
    }

    private static class ListNode {
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
}

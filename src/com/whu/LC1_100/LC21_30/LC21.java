package com.whu.LC1_100.LC21_30;

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
public class LC21 {
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//            设置一个头节点
            return recursion(list1, list2);
        }

        private ListNode recursion(ListNode list1, ListNode list2) {
//            将null视为为最大的max值
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            if (list1.val < list2.val) {
                list1.next = recursion(list1.next, list2);
                return list1;
            } else {
                list2.next = recursion(list1, list2.next);
                return list2;
            }
        }
    }
}

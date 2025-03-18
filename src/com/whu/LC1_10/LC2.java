package com.whu.LC1_10;

public class LC2 {

    //      Definition for singly-linked list.

    public static void main(String[] args) {

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

    private static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//          不可以O(n)转成int计算,因为链表长度很长
            ListNode head = new ListNode(0, null);
//            尾节点
            ListNode ptr = head;

//            代替短节点计算的0值节点
            ListNode temp = new ListNode(0, null);

            int carry = 0;
            while (l1 != null || l2 != null) {
                int sum = l1.val + l2.val;
                ptr.next = new ListNode(sum + carry, null);
                ptr = ptr.next;
                carry = ptr.val / 10;
                ptr.val = ptr.val % 10;

                if (l1.next == null && l2.next == null && carry == 0) {
                    break;
                }
                if (l1.next == null) {
                    l1 = temp;
                } else {
                    l1 = l1.next;
                }
                if (l2.next == null) {
                    l2 = temp;
                } else {
                    l2 = l2.next;
                }
            }
            return head.next;
        }
    }
}

package com.whu;

public class LC25 {
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 1) {
                return head;
            }
//            tail所指的元素的序号是多少
            int count = 1;
            ListNode res = new ListNode(0, head);
            ListNode ptr = res;
            ListNode tail = head;
            boolean flag = false;
            while (tail.next != null) {
                if (count % k == 0) {
                    ListNode next = tail.next;
                    ListNode start = ptr.next;
                    tail.next = null;
                    tail = next;
                    if (!flag) {
//                        记录的为第几组旋转,如果是第一组旋转的话
                        res.next = reverse(ptr.next);
                        flag = true;
                    } else {
                        ptr.next = reverse(ptr.next);
                    }
                    ptr = start;
                    start.next = tail;
                } else {
                    tail = tail.next;
                }
                count++;
            }
            return res.next;
        }

        private ListNode reverse(ListNode head) {
//            先写一个递归逆序的方法
            if (head.next == null) {
                return head;
            }
            ListNode newHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
//            返回的就一直是尾节点
            return newHead;
        }
    }
}

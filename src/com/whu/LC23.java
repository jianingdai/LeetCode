package com.whu;

public class LC23 {
    public static void main(String[] args) {
        Solution solution = new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] lists, int left, int right) {
//            lists是一个链表数组,每次调用时合并范围内的所有链表
            if (left == right) {
//                当调用到左等于右时直接返回该链表,因为链表内部已经有序
                return lists[left];
            } else if (left > right) {
                return null;
            }
            int mid = (left + right) / 2;
            return mergeTwo(merge(lists, left, mid), merge(lists, mid + 1, right));
        }

        private static ListNode mergeTwo(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
//                逻辑是当到递归尾时,若返回l1则说明l2是null,那么上一层就是mergeTwo(l1,l2.next)此时上一层的条件就是l1>=l2,l2.next is null ,just so do : l2.next= l1
                l1.next = mergeTwo(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwo(l1, l2.next);
                return l2;
            }
        }
    }
}

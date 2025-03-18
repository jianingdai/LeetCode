package com.whu.LC141_150;

import com.whu.ListNode;

import java.util.HashMap;

public class LC142 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            HashMap<ListNode, Integer> map = new HashMap<>();
            ListNode ptr = head;
            while (ptr != null) {
                if (map.get(ptr) != null) {
                    return ptr;
                } else {
                    map.put(ptr, 1);
                }
                ptr = ptr.next;
            }
            return null;
        }
    }
}

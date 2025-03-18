package com.whu.LC141_150;

import com.whu.ListNode;

import java.util.HashMap;

public class LC141 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            HashMap<ListNode, Integer> map = new HashMap<>();
            ListNode ptr = head;
            while (ptr != null) {
                if (map.get(ptr) != null) {
                    return true;
                } else {
                    map.put(ptr, 1);
                }
                ptr = ptr.next;
            }
            return false;
        }
    }
}

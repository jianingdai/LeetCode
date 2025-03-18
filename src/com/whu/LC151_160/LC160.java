package com.whu.LC151_160;

import com.whu.ListNode;

public class LC160 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            ListNode pA = headA, pB = headB;

            while (!(pA == pB && pA == null)) {
                if (pA == null) {
                    pA = headB;
                } else if (pB == null) {
                    pB = headA;
                }
                if (pA == pB) {
                    return pA;
                }
                pA = pA.next;
                pB = pB.next;
            }
            return null;
        }
    }
}

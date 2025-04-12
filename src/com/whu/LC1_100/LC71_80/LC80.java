package com.whu.LC1_100.LC71_80;

public class LC80 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            if (n < 2) return n;
            int slow = 2, fast = 2;
            while (fast < n) {
                if (nums[slow - 2] != nums[fast]) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
}

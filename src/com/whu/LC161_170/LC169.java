package com.whu.LC161_170;

public class LC169 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = 0;
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }
            return candidate;
        }
    }
}

package com.whu;

public class LC27 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int removeElement(int[] nums, int val) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[res++] = nums[i];
                }
            }
            return res;
        }
    }
}

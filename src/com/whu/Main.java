package com.whu;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int removeDuplicates(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    nums[res++] = nums[i];
                }
            }
            return res;
        }
    }
}

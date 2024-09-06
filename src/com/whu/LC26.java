package com.whu;

public class LC26 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int removeDuplicates(int[] nums) {
            int res = 1;
//            双指针
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[res++] = nums[i];
                }
            }
            return res;
        }
    }
}

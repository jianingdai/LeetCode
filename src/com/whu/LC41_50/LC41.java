package com.whu.LC41_50;

public class LC41 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) continue;
                int t = nums[i] - 1;
                while (t >= 0 && t < n && nums[t] != nums[i]) {
                    swap(nums, t, i);
                    t = nums[i] - 1;
                }
            }
            for (int i = 0; i < n; i++) {
                if (i + 1 != nums[i]) return i + 1;
            }
            return n + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

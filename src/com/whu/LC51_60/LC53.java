package com.whu.LC51_60;


public class LC53 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int maxSubArray(int[] nums) {
//            动态规划，记录以每个下标结尾的最大和连续子数组
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < dp.length; i++) {
                if (dp[i - 1] <= 0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = dp[i - 1] + nums[i];
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i : dp) {
                if (i >= max) {
                    max = i;
                }
            }
            return max;
        }
    }
}

package com.whu.LC1_100.LC51_60;

public class LC55 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public boolean canJump(int[] nums) {
//            dp[i]记录自己是否能够跳到i位置
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i]) {
                    for (int j = 1; j <= nums[i]; j++) {
                        if (i + j < dp.length) {
                            dp[i + j] = true;
                        }else {
                            return true;
                        }
                    }
                }
            }
            return dp[nums.length - 1];
        }
    }
}

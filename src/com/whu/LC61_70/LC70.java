package com.whu.LC61_70;

public class LC70 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int climbStairs(int n) {
            if(n == 1) return 1;
            if(n == 2) return 2;
            //dp[i]记录到达下标为i的位置可以有多少方法
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}

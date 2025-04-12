package com.whu.LC1_100.LC41_50;

import java.util.Arrays;

public class LC45 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.jump(new int[]{2, 3, 1, 1, 4});
    }

    private static class Solution {
        //        dp好理解
        public int jump(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
//            表示到dp[i]最少需要多少跳
            int[] dp = new int[len];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j < len) {
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                    }
                }
            }
            return dp[len - 1];
        }
    }
}

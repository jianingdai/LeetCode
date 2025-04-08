package com.whu.LC411_420;

import java.util.Arrays;

public class LC416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                if (dp[j - nums[i]]) {
                    dp[j] = true;
                }
            }
        }

        return dp[target];
    }
}

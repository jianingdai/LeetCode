package com.whu.LC291_300;

import java.util.Arrays;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        // dp[i]表示以i下标结尾的最长递增子序列的长度
        // dp[i]=max(dp[i],dp[j]+1) for j in [0,i)
        int n = nums.length;
        int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        dp[0]=1;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }

        return Arrays.stream(dp).max().orElse(-1);
    }
}

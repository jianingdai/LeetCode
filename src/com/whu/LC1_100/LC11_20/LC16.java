package com.whu.LC1_100.LC11_20;

import java.util.Arrays;

/*
给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。返回这三个数的和。假定每组输入只存在恰好一个解。
* */
public class LC16 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5};
        int target = -2;
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums, target));
    }

    private static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int diffValue = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int goal = target - nums[i];
                for (int left = i + 1, right = nums.length - 1; left < right; ) {
                    int temp = nums[left] + nums[right] - goal;
                    diffValue = Math.abs(nums[left] + nums[right] - goal) < Math.abs(diffValue) ? nums[left] + nums[right] - goal : diffValue;
//                    当nums[left]+nums[right]==goal与target最接近可以直接跳出
                    if (temp == 0) {
                        return target;
                    }
//                    当abs(nums[left]+nums[right]-goal)达到min        即abs(diffvalue)达到min
//                    diffValue=nums[left]+nums[right]+nums[i]-target
                    if (temp > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return target + diffValue;
        }
    }
}
